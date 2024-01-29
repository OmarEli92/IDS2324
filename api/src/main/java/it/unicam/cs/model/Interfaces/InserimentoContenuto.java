package it.unicam.cs.model.Interfaces;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;

public interface InserimentoContenuto {
    void inserisciPOI(POI poi);
    void inserisciItinerario(Itinerario itinerario);
    void inserisciEvento(Evento evento);
    void inserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale);
}

