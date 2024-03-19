package it.unicam.cs.observer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Interfaccia che espone i metodi per la gestione degli observer dei contest
 */
@Service
public interface ContestObservable<T extends ContestObserver> {

    /**
     * Metodo che permette di aggiungere un observer
     * @param observer observer da aggiungere
     */
    void aggiungiObserver(T observer);

    /**
     * Metodo che permette di rimuovere un observer
     * @param observer observer da rimuovere
     */
    void rimuoviObserver(T observer);

    /**Metodo che permette di notificare gli observer */
    void notifica();
}
