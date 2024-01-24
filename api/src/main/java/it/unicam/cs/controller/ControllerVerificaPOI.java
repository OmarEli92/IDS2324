package it.unicam.cs.controller;

import it.unicam.cs.model.POI;
import it.unicam.cs.service.VerificaPOIService;

public class ControllerVerificaPOI {
private final VerificaPOIService verificaPOIService;

    public ControllerVerificaPOI(VerificaPOIService verificaPOIService) {
        this.verificaPOIService = verificaPOIService;
    }

    public void verificaCoordinate(POI poi){
        this.verificaPOIService.verificaCoordinate(poi);
    }
    public void verificaPOI(POI poi){
        this.verificaPOIService.verificaPOI(poi);
    }
    public void validaPOI(POI poi){
        this.verificaPOIService.validaPOI(poi);
    }
    public void invalidaPOI(POI poi){
        this.verificaPOIService.invalidaPOI(poi);
    }
}
