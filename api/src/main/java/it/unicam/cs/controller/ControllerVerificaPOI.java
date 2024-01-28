package it.unicam.cs.controller;

import it.unicam.cs.controller.Interfaces.ControllerVerificaContenuto;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.POI;
import it.unicam.cs.service.VerificaPOIService;

public class ControllerVerificaPOI implements ControllerVerificaContenuto {
private final VerificaPOIService verificaPOIService;

    public ControllerVerificaPOI(VerificaPOIService verificaPOIService) {
        this.verificaPOIService = verificaPOIService;
    }

    public void verificaCoordinate(POI poi){
        this.verificaPOIService.verificaCoordinate(poi);
    }
    public void verificaContenuto(Contenuto poi){
        this.verificaPOIService.verificaPOI((POI) poi);
    }
    public void validaContenuto(Contenuto poi){
        this.verificaPOIService.validaPOI((POI) poi);
    }
    public void invalidaContenuto(Contenuto poi){
        this.verificaPOIService.invalidaPOI((POI) poi);
    }
}
