package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Abstractions.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.util.Posizione;

import java.util.List;

public interface IGeolocalizzazioneService {
    /** Metodo che restituisce la posizione del punto selezionato*/
    void getPosizione();
/** Metodo che restituisce l'indirizzo del punto selezionato*/
    void getIndirizzo();
    /** Metodo che mostra il POI richiesto tramite id*/
    void visualizzaPOI(int idPOI);
    /** Metodo che mostra l'evento richiesto tramite id*/
    void visualizzaEvento(int idEvento);

    /** Metodo che mostra l'itinerario richiesto tramite id*/
    void visualizzaItinerario(int idItinerario);
    /** Metodo che mostra tutti i POI presenti nel comune*/
    void visualizzaPOISComune(List<POI> pois);
    /** Metodo che mostra tutti gli eventi presenti nel comune*/
    void visualizzaEventiComune(List<Evento> eventi);
    /** Metodo che mostra tutti gli itinerari presenti nel comune*/
    void visualizzaItinerari(List<Itinerario> itinerari);
    /** Metodo che verifica se un punto è nel comune */
    void verificaPuntoNelComune(Posizione posizione, String comune);

}
