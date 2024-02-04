package it.unicam.cs.repository.Interfaces;



import it.unicam.cs.model.Itinerario;

import java.util.Map;

public interface IItinerarioRepository {
    /** Il metodo ottieniItinerari restituisce una mappa di itinerari **/
    Map<Integer, Itinerario> ottieniItinerari(int idComune);
    /** Il metodo ottieniItinerarioDaID restituisce un itinerario a partire dal suo id **/
    Itinerario ottieniItinerarioDaID(int idItinerario);
  
    void aggiungiItinerario(Itinerario itinerario);

    void aggiungiItinerarioInPending(Itinerario itinerario);

}
