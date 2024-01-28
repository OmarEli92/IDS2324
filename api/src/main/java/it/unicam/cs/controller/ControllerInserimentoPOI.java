package it.unicam.cs.controller;

import it.unicam.cs.controller.Interfaces.ControllerInserimentoContenuto;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.POI;
import it.unicam.cs.service.InserimentoPOIService;

public class ControllerInserimentoPOI implements ControllerInserimentoContenuto {
private final InserimentoPOIService inserimentoPOIService;
private final Comune comune;

    public ControllerInserimentoPOI(InserimentoPOIService inserimentoPOIService, Comune comune) {
        this.inserimentoPOIService = inserimentoPOIService;
        this.comune=comune;
    }

    @Override
    public void aggiungiContenuto(Contenuto poi) {
        this.inserimentoPOIService.aggiugiContenuto((poi));
    }

    @Override
    public void aggiungiContenutoInPending(Contenuto poi) {
        this.inserimentoPOIService.aggiugiContenutoInPending(poi);
    }
}
