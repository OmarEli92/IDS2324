package it.unicam.cs.model;

import java.util.List;
import java.util.Map;

public class Comune {
    private final String nome;
    private final int ID;
    private final Map<Integer,POI> POIS;
    private final Map<Integer,Itinerario> itinerari;
    private final Map<Integer,Evento> eventi;
    private final Map<Integer,Evento> eventiInPending;
    private final Map<Integer,POI> POISInPending;
    private final Map<Integer,Itinerario> ItinerariInPending;
    private final Map<Integer,Curatore> listaCuratori;
    private final int IDGestorePiattaforma;

    public Comune(String nome, int ID, Map<Integer,POI> POIS, Map<Integer,Itinerario> itinerari, Map<Integer,Evento> eventi,
                  Map<Integer,Evento> eventiInPending, Map<Integer,POI> POISInPending, Map<Integer,Itinerario> itinerariInPending,
                  Map<Integer,Curatore> listaCuratori, int IDGestorePiattaforma){
        this.nome = nome;
        this.ID = ID;
        this.POIS = POIS; //TODO da rimodellare quando si integra spring e persistenta nel db
        this.itinerari = itinerari; //TODO stessa cosa per eventi ,itinerari
        this.eventi = eventi;
        this.eventiInPending = eventiInPending;
        this.POISInPending = POISInPending;
        this.ItinerariInPending = itinerariInPending;
        this.listaCuratori = listaCuratori;
        this.IDGestorePiattaforma = IDGestorePiattaforma;

    }

    public void inserisciPOIInListaPending(int id,POI poi){
        POISInPending.put(id,poi);
    }

    public void inserisciItinerarioInListaPending(int id,Itinerario itinerario){
        ItinerariInPending.put(id,itinerario);
    }

    public void inserisciEventoInListaPending(int id, Evento evento){
        eventiInPending.put(id,evento);
    }

    public void inserisciPOI(int id, POI poi){
        POIS.put(id, poi);
    }

    public String getNome() {
        return nome;
    }

    public int getID() {
        return ID;
    }

    public Map<Integer,POI> getPOIS() {
        return POIS;
    }

    public Map<Integer,Itinerario> getItinerari() {
        return itinerari;
    }

    public Map<Integer,Evento> getEventi() {
        return eventi;
    }

    public Map<Integer,Evento> getEventiInPending() {
        return eventiInPending;
    }

    public Map<Integer,POI> getPOISInPending() {
        return POISInPending;
    }

    public Map<Integer,Itinerario> getItinerariInPending() {
        return ItinerariInPending;
    }

    public Map<Integer,Curatore> getListaCuratori() {
        return listaCuratori;
    }

    public int getIDGestorePiattaforma() {
        return IDGestorePiattaforma;
    }
}
