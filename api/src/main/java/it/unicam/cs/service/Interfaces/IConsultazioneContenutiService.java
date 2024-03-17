package it.unicam.cs.service.Interfaces;


import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.DTO.ItinerarioDto;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.abstractions.POI;

import java.util.List;


/** L'interfaccia IContenutiService è un servizio che gestisce tutta la logica di business relativa alla consultazione
 * dei contenuti nella piattaforma e fornisce metodi adibiti a tale scopo **/
public interface IConsultazioneContenutiService {

/** Il metodo ottieniComuneDaId recupera un comune a partire dal suo id
 * @param idComune **/
 public Comune ottieniComuneDaId(Integer idComune);

/** Il metodo ottieniComune recupera un comune a partire dal suo nome
 * @param comune **/
 public Comune ottieniComune(String comune);

  /**@param idPOI
  * Il metodo ottieniPOIdaId recupera un POI a partire dal suo id **/
    POI ottieniPOIdaId(Integer idPOI);

    /** Il metodo ottieniPOIS restituisce una mappa di POI **/
    List<PoiDto> ottieniPOIS(final Integer idComune);

    /**@param idEvento
     * Il metodo ottieniEventoDaId visualizza un evento a partire dal suo id **/
    Evento ottieniEventoDaId(Integer idEvento);

    /** Il metodo ottieniEventiDaId restituisce una mappa di eventi **/
    List<EventoDto> ottieniEventi(final Integer idComune);

    /**@param idItinerario
     *  Il metodo ottieniItinerarioDaId visualizza un itinerario a partire dal suo id **/
     Itinerario ottieniItinerarioDaId(Integer idItinerario);
    /** Il metodo ottieniItinerari restituisce la lista di itinerari associati al comune**/
    List<ItinerarioDto> ottieniItinerari(final Integer idComune);

 /** Il metodo ottieniContenutoMultimediale restituisce un contenuto multimediale
  *  @param id
  *  @return ContenutoMultimediale contenuto**/
 ContenutoMultimediale ottieniContenutoMultimedialeDaId(Integer id);

 /** Il metodo ottieniCotenutiMultimedialiPOI restituisce una lista di contenuti multimediali
  *  @param idPOI
  *  @return List<ContenutoMultimediale> contenuti**/
 List<ContenutoMultimediale> ottieniCotenutiMultimedialiPOI(Integer idPOI);


}
