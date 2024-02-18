package it.unicam.cs.service;

import it.unicam.cs.model.Contest;
import it.unicam.cs.repository.IContestRepository;
import it.unicam.cs.service.Interfaces.IContestService;

public class ContestService implements IContestService {
    private final IContestRepository contestRepository;

    public ContestService(IContestRepository contestRepository){
        this.contestRepository = contestRepository;
    }

    @Override
    public void aggiungiContest(Contest contest) {

    }

    @Override
    public void rimuoviContest(Contest contest) {

    }
}
