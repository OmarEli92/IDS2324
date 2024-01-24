package it.unicam.cs.controller;

import it.unicam.cs.model.POI;
import it.unicam.cs.service.InserimentoPOIService;

public class ControllerInserimentoPOI {
private final InserimentoPOIService inserimentoPOIService;

    public ControllerInserimentoPOI(InserimentoPOIService inserimentoPOIService) {
        this.inserimentoPOIService = inserimentoPOIService;
    }

    public void aggiungiPOI(POI poi){
        this.inserimentoPOIService.aggiugiPOI(poi);
    }
    public void aggiugiPOIInPending(POI poi){
        this.inserimentoPOIService.aggiugiPOIInPending(poi);
    }
}
