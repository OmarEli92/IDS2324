package it.unicam.cs.service.Interfaces;


import it.unicam.cs.util.info.DettagliComune;
import it.unicam.cs.util.info.Posizione;

import java.util.List;

/** Interfaccia che espone i metodi per la geocodifica e la geocodifica inversa  */
public interface IGeolocalizzazioneService {
    /** Restituisce la posizione del comune**/
    DettagliComune ottieniPosizioneComune(String comune);



    /** Metodo che verifica se un punto è nel comune
     * */
    boolean verificaPuntoNelComune(Posizione posizionePunto, Posizione[] posizioneComune);

    List<Posizione> ottieniPerimetro(String comune);
}
