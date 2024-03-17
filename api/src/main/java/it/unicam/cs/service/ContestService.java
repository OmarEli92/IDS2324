package it.unicam.cs.service;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.IContestRepository;
import it.unicam.cs.service.Interfaces.IContestService;
import it.unicam.cs.util.enums.RuoliUtente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContestService implements IContestService {
    private final IContestRepository contestRepository;

    public ContestService(IContestRepository contestRepository){
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
}
