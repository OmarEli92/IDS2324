package it.unicam.cs.controller;

import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.service.GestioneContenutiService;

//TODO da implementare correttamente
public class ControllerGestioneContenuto {
    private GestioneContenutiService gestioneContenutiService;

    public ControllerGestioneContenuto(GestioneContenutiService gestioneContenutiService) {
        this.gestioneContenutiService = gestioneContenutiService;
    }

}
