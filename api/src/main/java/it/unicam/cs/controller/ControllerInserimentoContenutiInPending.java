package it.unicam.cs.controller;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.service.ServiceInserimentoContenuti;
import it.unicam.cs.service.ServiceInserimentoContenutiInPending;

public class ControllerInserimentoContenutiInPending {
    private ServiceInserimentoContenutiInPending serviceInserimentoContenutiInPending;

    public ControllerInserimentoContenutiInPending(ServiceInserimentoContenutiInPending serviceInserimentoContenutiInPending) {
        this.serviceInserimentoContenutiInPending = serviceInserimentoContenutiInPending;
    }

    public void inserisciPOIInPending(POI poi){
        this.serviceInserimentoContenutiInPending.inserisciPOIInPending(poi);
    }
    public void inserisciEventoInPending(Evento evento){
        this.serviceInserimentoContenutiInPending.inserisciEventoInPending(evento);
    }
    public void inserisciItinerarioInPending(Itinerario itinerario){
        this.serviceInserimentoContenutiInPending.inserisciItinerarioInPending(itinerario);
    }
    public void InserisciContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale){
        this.serviceInserimentoContenutiInPending.inserisciContenutoMultimedialeInPending(contenutoMultimediale);
    }
}
