package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;

import java.util.Collection;

public interface IGestioneContenutiService {

    /** Ottieni tutti i poi in pending
     * @return collezione di poi **/
    Collection<POI> ottieniContenutiInPending(); //TODO sostituire POI con l'interfaccia del visitor

    /** modifica lo stato dell'itinerario da pending -> accettato
     **/
    void accettaContenuto(); // DA modificare

}
