package it.unicam.cs.model.Interfaces;

import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.abstractions.POI;

public interface InserimentoContenutoInPending {
    public void inserisciPOIInPending(POI poi);
    public void InserisciEventoInPending(Evento evento);
    public void InserisciItinerarioInPending(Itinerario itinerario);
    public void InserisciContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale);
}
