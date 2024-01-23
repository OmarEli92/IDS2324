package it.unicam.cs.repository;

import it.unicam.cs.model.Itinerario;

import java.util.Map;

public interface ItinerarioRepository {
    /** Il metodo ottieniItinerari restituisce una mappa di itinerari **/
    Map<Integer, Itinerario> ottieniItinerari();
    /** Il metodo ottieniItinerarioDaID restituisce un itinerario a partire dal suo id **/
    Itinerario ottieniItinerarioDaID(int idItinerario);

    void aggiungiItinerario(Itinerario itinerario);

    void aggiungiItinerrarioInPending(Itinerario itinerario);
}
