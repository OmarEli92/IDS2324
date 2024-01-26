package it.unicam.cs.controller;

import it.unicam.cs.controller.abstractions.ControllerInserimentoContenuto;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.POI;
import it.unicam.cs.service.InserimentoPOIService;

public class ControllerInserimentoPOI implements ControllerInserimentoContenuto {
private final InserimentoPOIService inserimentoPOIService;

    public ControllerInserimentoPOI(InserimentoPOIService inserimentoPOIService) {
        this.inserimentoPOIService = inserimentoPOIService;
    }

    @Override
    public void aggiungiContenuto(Contenuto poi) {
        this.inserimentoPOIService.aggiugiPOI((POI)poi);
    }

    @Override
    public void aggiungiContenutoInPending(Contenuto poi) {
        this.inserimentoPOIService.aggiugiPOIInPending((POI)poi);
    }
}
