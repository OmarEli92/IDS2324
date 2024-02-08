package it.unicam.cs.service.Interfaces;


import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;

import java.util.List;


/** L'interfaccia IContenutiService è un servizio che gestisce tutta la logica di business relativa alla consultazione
 * dei contenuti nella piattaforma e fornisce metodi adibiti a tale scopo **/
public interface IConsultazioneContenutiService {

   /**@param idPOI
   * Il metodo ottieniPOIdaId recupera un POI a partire dal suo id **/
    POI ottieniPOIdaId(String idPOI);

    /** Il metodo ottieniPOIS restituisce una mappa di POI **/
    List<POI> ottieniPOIS(final String idComune);

    /**@param idEvento
     * Il metodo ottieniEventoDaId visualizza un evento a partire dal suo id **/
    Evento ottieniEventoDaId(String idEvento);

    /** Il metodo ottieniEventiDaId restituisce una mappa di eventi **/
    List<Evento> ottieniEventi(final String idComune);

    /**@param idItinerario
     *  Il metodo ottieniItinerarioDaId visualizza un itinerario a partire dal suo id **/
     Itinerario ottieniItinerarioDaId(String idItinerario);
    /** Il metodo ottieniItinerari restituisce la lista di itinerari associati al comune**/
    List<Itinerario> ottieniItinerari(final String idComune);

 /** Il metodo ottieniContenutoMultimediale restituisce un contenuto multimediale
  *  @param id
  *  @return ContenutoMultimediale contenuto**/
 ContenutoMultimediale ottieniContenutoMultimedialeDaId(String id);

 /** Il metodo ottieniCotenutiMultimedialiPOI restituisce una lista di contenuti multimediali
  *  @param idPOI
  *  @return List<ContenutoMultimediale> contenuti**/
 List<ContenutoMultimediale> ottieniCotenutiMultimedialiPOI(String idPOI);


}
