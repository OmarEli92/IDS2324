package it.unicam.cs.service;

import it.unicam.cs.Mediators.ContestMediator;
import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IContestRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.service.Interfaces.IContestService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContestService implements IContestService {
    private final IContestRepository contestRepository;
    private IUtenteService utenteService;
    private POIService poiService;
    private ContestMediator contestMediator;
    private ConsultazioneContenutiService consultazioneContenutiService;
    public ContestService(IContestRepository contestRepository, IPOIRepository poiRepository){
        this.contestRepository = contestRepository;
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
    public void assegnaVincitoreContest(Contest contest, Utente utente, ContenutoContest contenutoContest) {
        if(contest.isAttivo()&& contest.getVincitore() == null){
            contest.setVincitore(contenutoContest,utente);
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

    @Override
    public void apriContest(Contest contest) {
        contest.setAttivo(true);
        contestRepository.save(contest);
    }

    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public void verificaScadenze(){
        LocalDate oggi = LocalDate.now();
        List<Contest> contestScaduti = contestRepository.findByDataFineBeforeAndAttivoIsTrue(oggi);
        contestScaduti.forEach(contest -> {chiudiContest(contest);
        List<Utente> utenti = contest.getPartecipantiContest();
        utenti.forEach(utente -> {contest.rimuoviObserver(utente);
        utenteService.salvaUtente(utente);});
        contestMediator.chiudiContest(contest.getId());
        });
    }
    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public void verificaAperture(){
        LocalDate oggi = LocalDate.now();
        List<Contest> contestDaAprire = contestRepository.findByDataInizioBeforeAnsAttivoIsFalse(oggi);
        contestDaAprire.forEach(contest -> {apriContest(contest);
        contestMediator.apriContest(contest.getId());});
    }
}
