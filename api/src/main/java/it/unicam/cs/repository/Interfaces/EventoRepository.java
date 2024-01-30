package it.unicam.cs.repository.Interfaces;

import it.unicam.cs.exception.EventoNotFoundException;
import it.unicam.cs.model.Evento;

import java.util.Map;
/** L'interfaccia EventoRepository è un repository che gestisce la persistenza dei dati relativi agli eventi
 * nella piattaforma e fornisce metodi adibiti a tale scopo **/
public interface EventoRepository {
    /** Il metodo ottieniEventi restituisce una mappa di eventi **/
     Map<Integer, Evento> ottieniEventi(int idComune);
  
    /** Il metodo ottieniEventoDaID restituisce un evento a partire dal suo id **/
    Evento ottieniEventoDaID(int idEvento);
  
  /** Il metodo aggiungiEvento aggiunge un evento **/
    void aggiungiEvento(Evento evento);
  
/** Il metodo aggiungiEventoInPending aggiunge un evento non ancora verificato alla lista di pending**/
    void aggiungiEventoInPending(Evento evento);

}
