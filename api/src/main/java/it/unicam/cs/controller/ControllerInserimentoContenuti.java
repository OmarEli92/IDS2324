package it.unicam.cs.controller;

import it.unicam.cs.exception.EventoNotValidException;
import it.unicam.cs.exception.POINotValidException;
import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.service.Interfaces.IInserimentoContenutiService;
import it.unicam.cs.service.ServiceInserimentoContenuti;

public class ControllerInserimentoContenuti {
    private final ServiceInserimentoContenuti serviceInserimentoContenuti;

    public ControllerInserimentoContenuti(ServiceInserimentoContenuti serviceInserimentoContenuti) {
        this.serviceInserimentoContenuti = serviceInserimentoContenuti;
    }
    public void inserisciPOI (POI poi) throws POINotValidException {
        this.serviceInserimentoContenuti.inserisciPOI(poi);
    }
    public void inserisciItinerario (Itinerario itinerario){
        this.serviceInserimentoContenuti.inserisciItinerario(itinerario);
    }
    public void inserisciEvento (Evento evento) throws EventoNotValidException {
        this.serviceInserimentoContenuti.inserisciEvento(evento);
    }
    public void inserisciContenutoMultimediale (ContenutoMultimediale contenutoMultimediale){
        this.serviceInserimentoContenuti.inserisciContenutoMultimediale(contenutoMultimediale);
    }
}
