package it.unicam.cs.controller;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.service.ServiceInserimentoContenuti;

public class ControllerInserimentoContenuti {
    private ServiceInserimentoContenuti serviceInserimentoContenuti;

    public ControllerInserimentoContenuti(ServiceInserimentoContenuti serviceInserimentoContenuti) {
        this.serviceInserimentoContenuti = serviceInserimentoContenuti;
    }

    public void inserisciPOI(POI poi){
        this.serviceInserimentoContenuti.inserisciPOI(poi);
    }

    public void inserisciEvento(Evento evento){
        this.serviceInserimentoContenuti.inserisciEvento(evento);
    }
    public void inserisciItinerario (Itinerario itinerario){
        this.serviceInserimentoContenuti.inserisciItinerario(itinerario);
    }
    public void inserisciContenutoMultimediale (ContenutoMultimediale contenutoMultimediale){
        this.serviceInserimentoContenuti.inserisciContenutoMultimediale(contenutoMultimediale);
    }
}
