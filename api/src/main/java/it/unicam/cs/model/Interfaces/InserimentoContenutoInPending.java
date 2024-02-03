package it.unicam.cs.model.Interfaces;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Abstractions.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.Abstractions.POI;

public interface InserimentoContenutoInPending {
    public void inserisciPOIInPending(POI poi);
    public void InserisciEventoInPending(Evento evento);
    public void InserisciItinerarioInPending(Itinerario itinerario);
    public void InserisciContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale);
}
