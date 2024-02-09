package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;

import java.util.List;

/** Interfaccia che espone i metodi per visualizzare i POI, gli eventi e gli itinerari presenti in un dato comune*/
public interface IMappaService {
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
}
