package it.unicam.cs.controller;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.POI;
import it.unicam.cs.service.InserimentoContenutiMultimedialiService;

public class ControllerInserimentoContenutoMultimediale  {
    private final InserimentoContenutiMultimedialiService inserimentoContenutiMultimedialiService;
    public ControllerInserimentoContenutoMultimediale(InserimentoContenutiMultimedialiService inserimentoContenutiMultimedialiService, POI poi) {
        this.inserimentoContenutiMultimedialiService = inserimentoContenutiMultimedialiService;
    }


    public void aggiungiContenuto(ContenutoMultimediale contenutoMultimediale) {
        this.inserimentoContenutiMultimedialiService.aggiungiContenutoMultimediale(contenutoMultimediale);
    }


    public void aggiungiContenutoInPending(Contenuto contenuto) {

    }
}
