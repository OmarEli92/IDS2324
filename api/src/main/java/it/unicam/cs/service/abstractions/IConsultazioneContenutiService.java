package it.unicam.cs.service.abstractions;


import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;

import java.util.Map;

/** L'interfaccia IContenutiService è un servizio che gestisce tutta la logica di business relativa alla consultazione
 * dei contenuti nella piattaforma e fornisce metodi adibiti a tale scopo **/
public interface IConsultazioneContenutiService {


/**@param idPOI
 * Il metodo ottieniPOIdaId recupera un POI a partire dal suo id **/
    POI ottieniPOIdaId(int idPOI);

    /** Il metodo ottieniPOIS restituisce una mappa di POI **/
    Map<Integer,POI> ottieniPOIS();

    /**@param idEvento
     * Il metodo ottieniEventoDaId visualizza un evento a partire dal suo id **/
    Evento ottieniEventoDaId(int idEvento);

    /** Il metodo ottieniEventiDaId restituisce una mappa di eventi **/
    Map<Integer, Evento> ottieniEventi();

    /**@param idItinerario
     *  Il metodo ottieniItinerarioDaId visualizza un itinerario a partire dal suo id **/
     Itinerario ottieniItinerarioDaId(int idItinerario);

    Map<Integer, Itinerario> ottieniItinerari();


}
