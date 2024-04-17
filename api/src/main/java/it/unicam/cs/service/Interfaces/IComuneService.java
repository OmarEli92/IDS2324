package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;

import java.util.Optional;

public interface IComuneService {
    /** Aggiunge comune
     * @Return id del comune aggiunto**/
    void aggiungiComune(Comune comune);
    /** Rimuove comune tramite id**/
    void rimuoviComune(int idComune);
    /** Rimuove comune tramite nome***/
    void rimuoviComune(String nomeComune);
    /**Aggiunge gestore Comune
     *@Return id gestore Comune **/
    int aggiungiGestoreComune(Utente gestoreComune,String comune);
    /**Rimuove gestore comune**/
    void rimuoviGestoreComune(int idGestore, String comune);
    /** Ottieni comune da id**/
    Optional<Comune> ottieniComune(int idComune);
    /** Ottieni comune da nome**/
    Optional<Comune> ottieniComune(String nomeComune);
}
