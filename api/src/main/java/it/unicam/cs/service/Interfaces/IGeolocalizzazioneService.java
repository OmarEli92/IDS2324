package it.unicam.cs.service.Interfaces;


import it.unicam.cs.util.info.Posizione;

/** Interfaccia che espone i metodi per la geocodifica e la geocodifica inversa  */
public interface IGeolocalizzazioneService {
    /** Restituisce la posizione del comune**/
    Posizione ottieniPosizioneComune(String comune);



    /** Metodo che verifica se un punto è nel comune */
    boolean verificaPuntoNelComune(Posizione posizione, String comune);

}
