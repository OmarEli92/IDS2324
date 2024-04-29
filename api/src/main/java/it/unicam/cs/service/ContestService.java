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
    public void assegnaVincitoreContest(int idContest, Utente utente) {
        Contest contest = contestRepository.getReferenceById(idContest);
        if(contest.isAttivo() && contest.getVincitore() == null){
            contest.setVincitore(utente);
            chiudiContest(contest);
            String tipoPOI = contest.getTipoPOI();
            POI poiEsistente = poiRepository.
                    findAll()
                    .stream()
                    .filter(poi -> poi.getPosizione().equals(contest.getLuogo()))
                            .findFirst()
                    .orElse(null);
            if(poiEsistente == null) {
                //poiEsistente = .. il nuovo poi costruito;
                //TODO costruzione del POI a seconda del design pattern utilizzato
            }
            ContenutoContest vincente = contest.getContenutiCaricati()
                    .stream()
                            .filter(contenuto -> contenuto.getPartecipante().equals(utente))
                                    .findFirst().orElse(null);
            poiEsistente.aggiungiContenutoMultimediale(vincente.getContenutoMultimediale());
            contest.setVincitore(utente);
            contest.notifica();
        }
    }

    @Override
    public void chiudiContest(Contest contest) {
        contest.setAttivo(false);
        contestRepository.save(contest);
    }
}
