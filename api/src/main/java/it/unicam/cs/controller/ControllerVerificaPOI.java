package it.unicam.cs.controller;

import it.unicam.cs.controller.Abstractions.AbstractControllerVerificaContenuto;
import it.unicam.cs.service.Abstractions.AbstractVerificaContenutoService;
import it.unicam.cs.service.VerificaPOIService;
import it.unicam.cs.util.Posizione;

public class ControllerVerificaPOI extends AbstractControllerVerificaContenuto {
    public ControllerVerificaPOI(AbstractVerificaContenutoService verificaContenutoService) {
        super(verificaContenutoService);
    }
    public void verificaCoordinate(Posizione posizione){
        ((VerificaPOIService)this.verificaContenutoService).verificaCoordinate(posizione);
    }
}
