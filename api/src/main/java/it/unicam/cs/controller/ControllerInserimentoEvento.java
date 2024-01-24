package it.unicam.cs.controller;

import it.unicam.cs.model.Evento;
import it.unicam.cs.service.InserimentoEventiService;

public class ControllerInserimentoEvento {
private final InserimentoEventiService inserimentoEventiService;

    public ControllerInserimentoEvento(InserimentoEventiService inserimentoEventiService) {
        this.inserimentoEventiService = inserimentoEventiService;
    }

    public void aggiungiEvento(Evento evento){
        this.inserimentoEventiService.aggiungiEvento(evento);
    }

    public void aggiungiEventoInPending(Evento evento){
        this.inserimentoEventiService.aggiungiEventoInPending(evento);
    }

}
