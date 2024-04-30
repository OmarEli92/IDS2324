package it.unicam.cs.service;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IContestRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.service.Interfaces.IContestService;
import it.unicam.cs.util.enums.RuoliUtente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContestService implements IContestService {
    private final IContestRepository contestRepository;
    private final IPOIRepository poiRepository;
    private ConsultazioneContenutiService consultazioneContenutiService;
    public ContestService(IContestRepository contestRepository, IPOIRepository poiRepository){
        this.contestRepository = contestRepository;
        this.poiRepository = poiRepository;
    }

    @Override
    public void aggiungiContest(Contest contest) {
        this.contestRepository.save(contest);
    }

    @Override
    public void rimuoviContest(Contest contest) {
        this.contestRepository.delete(contest);
    }

    @Override
    public Contest ottieniContest(Integer id) {
        return this.contestRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contest> ottieniContests() {
        return StreamSupport.stream(this.contestRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean aggiungiPartecipanti(Integer idContest, List<Utente> partecipanti) {
        if(this.contestRepository.existsById(idContest)){
            Contest contest = contestRepository.getReferenceById(idContest);
            for(Utente utente : partecipanti) {
                utente.getRuoli().add(new Ruolo(1, RuoliUtente.PARTECIPANTE_CONTEST.toString()));
                contest.aggiungiObserver(utente);
            }
            contestRepository.save(contest);
            return true;
        }
        return false;
    }

    @Override
    public Page<ContenutoContest> visionaContenutiCaricati(Integer idContest,int page, int size){
        Contest contest = contestRepository.getReferenceById(idContest);
        if(contest == null){
            return null;
        }
        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, contest.getContenutiCaricati().size());
        List<ContenutoContest> pageContent = contest.getContenutiCaricati().subList(startIndex, endIndex);
        PageRequest pageRequest = PageRequest.of(page, size);
        return new PageImpl<>(pageContent, pageRequest, contest.getContenutiCaricati().size());
    }

    @Override
    public void assegnaVincitoreContest(Contest contest, Utente utente) {
        if(contest.isAttivo()&& contest.getVincitore() == null){
            contest.setVincitore(utente);
            chiudiContest(contest);
            contest.notifica();
        }
    }

    @Override
    public void aggiungiContenutoContest(Integer idContest, ContenutoContest contenutoContest) {
        Contest contest = contestRepository.getReferenceById(idContest);
        contest.aggiungiContenutoCaricato(contenutoContest);
        contestRepository.save(contest);
    }
    public void aggiornaListaContenutoContest(Integer idContest, boolean validato){
        Contest contest = contestRepository.findContestByContenutoContestId(idContest);
        if(validato){
            contest.getContenutiCaricati()
                    .stream()
                    .filter(contenutoContest -> contenutoContest.getId().equals(idContest))
                    .forEach(contenutoContest -> contenutoContest.setPending(false));
            contestRepository.save(contest);
        }
        else {
            ContenutoContest contenutoContest = consultazioneContenutiService.ottieniContenutoContestDaid(idContest);
            contest.getContenutiCaricati().remove(contenutoContest);
            contestRepository.save(contest);
        }
    }

    @Override
    public void chiudiContest(Contest contest) {
        contest.setAttivo(false);
        contestRepository.save(contest);
    }
}
