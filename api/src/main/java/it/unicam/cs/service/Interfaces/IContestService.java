package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Utente;

import java.util.List;

/**
 * Interfaccia service che espone i metodi per la gestione dei contest
 */
public interface IContestService {
    /**
     * Metodo che permette di aggiungere un contest
     * @param contest contest da aggiungere
     */
    void aggiungiContest(Contest contest);
    /**
     * Metodo che permette di rimuovere un contest
     * @param contest contest da rimuovere
     */
    void rimuoviContest(Contest contest);

    /**
     * Metodo che permette di ottenere un contest a partire dal suo id
     * @param id id del contest
     * @return contest
     */
    Contest ottieniContest(Integer id);

    /**
     * Metodo che permette di ottenere tutti i contest
     * @return lista di contest
     */
    List<Contest> ottieniContests();

    /** Metodo che permette di aggiungere i partecipanti**/
    boolean aggiungiPartecipanti(Integer idContest,List<Utente> partecipanti);


}
