package it.unicam.cs.model.Interfaces;

import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.abstractions.POI;

public interface VerificaContenuto {
    void verificaPOI(POI poi);
    void verificaEvento(Evento evento);

    void verificaItinerario(Itinerario itinerario);
}

