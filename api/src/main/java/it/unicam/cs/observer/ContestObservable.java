package it.unicam.cs.observer;
/**
 * Interfaccia che espone i metodi per la gestione degli observer dei contest
 */
public interface ContestObservable {
    /**
     * Metodo che permette di aggiungere un observer
     * @param observer observer da aggiungere
     */
    void aggiungiObserver(ContestObserver observer);
    /**
     * Metodo che permette di rimuovere un observer
     * @param observer observer da rimuovere
     */
    void rimuoviObserver(ContestObserver observer);

    /**Metodo che permette di notificare gli observer */
    void notifica();
}
