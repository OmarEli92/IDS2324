package it.unicam.cs.service.Interfaces;


import it.unicam.cs.util.info.Posizione;

/** Interfaccia che espone i metodi per la geocodifica e la geocodifica inversa  */
public interface IGeolocalizzazioneService {
    Posizione getPosizioneComune(String comune);
    /** Metodo che restituisce la posizione del punto selezionato*/
    void getPosizione();
/** Metodo che restituisce l'indirizzo del punto selezionato*/
    void getIndirizzo(Posizione posizione);
    /** Metodo che mostra il POI richiesto tramite id*/

    /** Metodo che verifica se un punto è nel comune */
    void verificaPuntoNelComune(Posizione posizione, String comune);

}
