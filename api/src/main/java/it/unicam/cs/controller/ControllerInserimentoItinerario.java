package it.unicam.cs.controller;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.service.InserimentoItinerariService;
import it.unicam.cs.service.Interfaces.IInserimentoContenutiService;

public class ControllerInserimentoItinerario implements IInserimentoContenutiService {
private final InserimentoItinerariService inserimentoItinerariService;

    public ControllerInserimentoItinerario(InserimentoItinerariService inserimentoItinerariService) {
        this.inserimentoItinerariService = inserimentoItinerariService;
    }

    @Override
    public void aggiungiContenuto(Contenuto itinerario) {
        this.inserimentoItinerariService.aggiungiContenuto(itinerario);
    }

    @Override
    public void aggiungiContenutoInPending(Contenuto itinerario) {
        this.inserimentoItinerariService.aggiungiContenutoInPending(itinerario);
    }
}
