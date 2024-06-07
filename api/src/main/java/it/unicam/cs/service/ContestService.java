package it.unicam.cs.service;

import it.unicam.cs.Mediators.ContestMediator;
import it.unicam.cs.exception.Contest.DataContestNotValidException;
import it.unicam.cs.exception.Contest.ListaPartecipantiNotValidException;
import it.unicam.cs.exception.UtenteNotValidException;
import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IContestRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.IRuoloRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.Interfaces.IContestService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.VerificaSomiglianzaContenuti;
import it.unicam.cs.util.enums.RuoliUtente;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ContestService implements IContestService {
    private final IContestRepository contestRepository;
    private IRuoloRepository ruoloRepository;
    private UtenteRepository utenteRepository;
    private ConsultazioneContenutiService consultazioneContenutiService;
    private VerificaSomiglianzaContenuti verificaSomiglianzaContenuti;

    @Override
    public void aggiungiContest(Contest contest) {
        if(!verificaSomiglianzaContenuti.verificaSomiglianzaContest(contest,contestRepository.findAll())){
            contestRepository.save(contest);
        }
        else {
            throw new IllegalArgumentException("contest già esistente");
        }
    }

    @Override
    public void rimuoviContest(Contest contest) {
        this.contestRepository.delete(contest);
    }

    @Override
    public Contest ottieniContest(Integer id) {
        return this.contestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("contest non esistente"));
    }

    @Override
    public List<Contest> ottieniContests() {
        return StreamSupport.stream(this.contestRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void aggiungiPartecipanti(Integer idContest, List<Integer> idPartecipanti) {
        List<Utente> partecipanti = utenteRepository.findAllById(idPartecipanti);
        Contest contest = contestRepository.caricaPartecipantiContest(idContest);
        contestValido(contest);
        for(Utente partecipante : partecipanti) {
            if (contest.getPartecipantiContest().contains(partecipante)) {
                partecipanti.remove(partecipante);
            }
            if (partecipante.getRuoli().stream()
                    .map(Ruolo::getNome).collect(Collectors.toList()).contains(RuoliUtente.ANIMATORE.name())
                    && partecipante.getContestCreati().stream()
                    .map(Contest::getId).collect(Collectors.toList()).contains(contest.getId())) {
               partecipanti.remove(partecipante);
            }
            if(!partecipante.getRuoli().stream()
                    .map(Ruolo::getNome).collect(Collectors.toList())
                    .contains(RuoliUtente.PARTECIPANTE_CONTEST.name())) {
                    partecipante.getRuoli().add(ruoloRepository.findByNome(RuoliUtente.PARTECIPANTE_CONTEST.name()));
                }
            if(partecipanti.contains(partecipante)) {
                contest.aggiungiObserver(partecipante);
            }
        }
        if(!(partecipanti.size() > 0)){
            throw new ListaPartecipantiNotValidException();
        }
        contestRepository.save(contest);
    }

    private void contestValido(Contest contest) {
        if(contest.getDataFine().isBefore(LocalDate.now())){
            throw new DataContestNotValidException();
        }

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
    @Transactional
    public void aggiungiContenutoContest(Integer idContest, ContenutoContest contenutoContest) {
        Contest contest = contestRepository.findById(idContest).orElseThrow(() -> new EntityNotFoundException("contest non trovato"));
        contest.aggiungiContenutoCaricato(contenutoContest);
        contestRepository.save(contest);
    }
    @Override
    @Transactional
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

}
