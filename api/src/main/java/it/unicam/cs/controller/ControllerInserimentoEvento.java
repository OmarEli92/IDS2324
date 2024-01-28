package it.unicam.cs.controller;

import it.unicam.cs.controller.Interfaces.ControllerInserimentoContenuto;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Evento;
import it.unicam.cs.service.InserimentoEventiService;

public class ControllerInserimentoEvento implements ControllerInserimentoContenuto {
private final InserimentoEventiService inserimentoEventiService;
private final Comune comune;

    public ControllerInserimentoEvento(InserimentoEventiService inserimentoEventiService,Comune comune) {
        this.inserimentoEventiService = inserimentoEventiService;
        this.comune=comune;
    }

    public void aggiungiContenuto(Contenuto evento){
        this.inserimentoEventiService.aggiungiContenuto(evento);
    }

    public void aggiungiContenutoInPending(Contenuto evento){
        this.inserimentoEventiService.aggiungiContenutoInPending(evento);
    }

}
