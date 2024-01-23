package it.unicam.cs.service.abstractions;


import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;

import java.util.Map;

/** L'interfaccia IContenutiService è un servizio che gestisce tutta la logica di business relativa alla consultazione
 * dei contenuti nella piattaforma e fornisce metodi adibiti a tale scopo **/
public interface IContenutiService {

    void selezionaComune(String nomeComune);

    void visualizzaPOI(int idPOI);

    void visualizzaPOIS();
    Map<Integer,POI> ottieniPOIS();

    void visualizzaEvento(int idEvento);

    void visualizzaEventi();
    Map<Integer, Evento> ottieniEventi();

     void visualizzaItinerario(int idItinerario);
     void visualizzaItinerari();

    Map<Integer, Itinerario> ottieniItinerari();


}
