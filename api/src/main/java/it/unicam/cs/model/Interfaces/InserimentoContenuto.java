package it.unicam.cs.model.Interfaces;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Abstractions.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.Abstractions.POI;

public interface InserimentoContenuto {
    void inserisciPOI(POI poi);
    void inserisciItinerario(Itinerario itinerario);
    void inserisciEvento(Evento evento);
    void inserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale);
}

