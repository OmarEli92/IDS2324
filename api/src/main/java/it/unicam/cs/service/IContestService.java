package it.unicam.cs.service;

import it.unicam.cs.model.Contest;
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

}
