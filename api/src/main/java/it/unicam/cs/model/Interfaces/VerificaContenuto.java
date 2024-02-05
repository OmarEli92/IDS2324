package it.unicam.cs.model.Interfaces;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;

public interface VerificaContenuto {
    void validaPOI(POI poi);
    void validaEvento(Evento evento);
    void validaItinerario(Itinerario itinerario);
    void validaContenutoMultimediale (ContenutoMultimediale contenutoMultimediale);
}

