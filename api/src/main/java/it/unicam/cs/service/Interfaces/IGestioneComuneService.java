package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Utente;

import java.util.Collection;
import java.util.Optional;

public interface IGestioneComuneService {
    /** Restituisce il curatore del comune
     * @param idCuratore
     * @return Utente**/
    Optional<Utente> ottieniCuratore(int idCuratore);

    /** Restituisce il curatore del comune**/
    Collection<Utente> ottieniCuratori(int idComune);

    /** Aggiunge il curatore del comune**/
    void aggiungiCuratore(Utente curatore);

    /** Rimuovi il curatore del comune**/
    void rimuoviCuratore(int idCuratore);

}
