package it.unicam.cs.controller;

import it.unicam.cs.service.VerificaPOIService;
import it.unicam.cs.util.Posizione;

public class ControllerVerificaPOI{
    private final VerificaPOIService verificaPOIService;
    public ControllerVerificaPOI(VerificaPOIService verificaPOIService) {
        this.verificaPOIService = verificaPOIService;

    }
    public void verificaCoordinate(Posizione posizione){
        verificaPOIService.verificaCoordinate(posizione);
    }
}
