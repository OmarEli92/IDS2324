package it.unicam.cs.controller;

import it.unicam.cs.service.Interfaces.IContestService;

public class ControllerContest {
    private final IContestService contestService;

    public ControllerContest(IContestService contestService) {
        this.contestService = contestService;
    }
}
