package it.unicam.cs.model.Interfaces;

import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;

public interface VerificaContenuto {
    void verificaPOI(POI poi);
    void verificaEvento(Evento evento);

    void verificaItinerario(Itinerario itinerario);
}

