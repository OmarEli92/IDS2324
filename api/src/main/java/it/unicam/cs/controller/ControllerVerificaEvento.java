package it.unicam.cs.controller;

import it.unicam.cs.controller.abstractions.ControllerVerificaContenuto;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Evento;
import it.unicam.cs.service.VerificaEventiService;

public class ControllerVerificaEvento implements ControllerVerificaContenuto {
private final VerificaEventiService verificaContenutiService;

    public ControllerVerificaEvento(VerificaEventiService verificaContenutiService) {
        this.verificaContenutiService = verificaContenutiService;
    }
   public void verificaContenuto(Contenuto evento){
        this.verificaContenutiService.verificaEvento((Evento) evento);
   }
   public void validaContenuto(Contenuto evento){
        this.verificaContenutiService.validaEvento((Evento) evento);
   }
   public void invalidaContenuto(Contenuto evento){
        this.verificaContenutiService.invalidaEvento((Evento) evento);
   }
}
