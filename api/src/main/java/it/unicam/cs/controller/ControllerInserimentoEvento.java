package it.unicam.cs.controller;

import it.unicam.cs.controller.abstractions.ControllerInserimentoContenuto;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Evento;
import it.unicam.cs.service.InserimentoEventiService;

public class ControllerInserimentoEvento implements ControllerInserimentoContenuto {
private final InserimentoEventiService inserimentoEventiService;

    public ControllerInserimentoEvento(InserimentoEventiService inserimentoEventiService) {
        this.inserimentoEventiService = inserimentoEventiService;
    }

    public void aggiungiContenuto(Contenuto evento){
        this.inserimentoEventiService.aggiungiEvento((Evento) evento);
    }

    public void aggiungiContenutoInPending(Contenuto evento){
        this.inserimentoEventiService.aggiungiEventoInPending((Evento) evento);
    }

}
