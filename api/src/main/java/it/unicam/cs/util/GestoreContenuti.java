package it.unicam.cs.util;

import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;


/** La classe GestoreContenuti è una classe temporanea che serve a fissare la logica della gestione
 * dei contenuti nella piattaforma senza essere influenzati dalla logica di implementazione della persistenza
 * dei dati tramite database o filesystem.
 * contiene quindi POI, eventi , itinerari **/
public interface GestoreContenuti {

/** Il metodo aggiungiPOI aggiunge un POI alla lista dei POI presenti nella piattaforma**/
    void aggiungiPOI(POI poi);

    /*** Il metodo aggiungiItinerario aggiunge un Itinerario alla lista degli itinerari presenti nella piattaforma**/
    void aggiungiItinerario(Itinerario itinerario);

/*** Il metodo aggiungiEvento aggiunge un Evento alla lista degli eventi presenti nella piattaforma**/
    void aggiungiEvento(Evento evento);
}
