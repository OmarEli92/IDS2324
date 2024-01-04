package it.unicam.cs.util;

import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;

import java.util.ArrayList;
import java.util.List;

/** La classe GestoreContenuti è una sorta di magazzino dei contenuti caricati sulla piattaforma
 * contiene quindi POI, eventi , itinerari **/
public class GestoreContenuti {
    private List<POI> listaPOI = new ArrayList<>();
    private List<Evento> listaEventi = new ArrayList<>();
    private List<Itinerario> listaItinerari = new ArrayList<>();

    public void aggiungiPOI(POI poi){
        listaPOI.add(poi);
    }

    public void aggiungiEvento(Evento evento){
        listaEventi.add(evento);
    }

    public void aggiungiItinerario(Itinerario itinerario){
        listaItinerari.add(itinerario);
    }
}
