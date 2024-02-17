package it.unicam.cs.model.Interfaces;

import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.abstractions.POI;

public interface InserimentoContenuto {
    void inserisciPOI(POI poi);
    void inserisciItinerario(Itinerario itinerario);
    void inserisciEvento(Evento evento);
    void inserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale);
}

