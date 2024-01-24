package it.unicam.cs.controller;

import it.unicam.cs.model.Evento;
import it.unicam.cs.service.VerificaEventiService;

public class ControllerVerificaEvento {
private final VerificaEventiService verificaContenutiService;

    public ControllerVerificaEvento(VerificaEventiService verificaContenutiService) {
        this.verificaContenutiService = verificaContenutiService;
    }
    public void verificaEvento(Evento evento){
        this.verificaContenutiService.verificaEvento(evento);
    }
    public void validaEvento(Evento evento){
        this.verificaContenutiService.validaEvento(evento);
    }
    public void invalidaEvento(Evento evento){
        this.invalidaEvento(evento);
    }
}
