package it.unicam.cs.model;

import java.util.List;

public class Comune {
    private final String nome;
    private final int ID;
    private final List<POI> POIS;
    private final List<Itinerario> itinerari;
    private final List<Evento> eventi;
    private final List<Evento> eventiInPending;
    private final List<POI> POISInPending;
    private final List<Itinerario> ItinerariInPending;
    private final Curatore curatore;


    public Comune(String nome, int ID, List<POI> POIS, List<Itinerario> itinerari, List<Evento> eventi,
                  List<Evento> eventiInPending, List<POI> POISInPending, List<Itinerario> itinerariInPending,
                  Curatore curatore) {
        this.nome = nome;
        this.ID = ID;
        this.POIS = POIS;
        this.itinerari = itinerari;
        this.eventi = eventi;
        this.eventiInPending = eventiInPending;
        this.POISInPending = POISInPending;
        this.ItinerariInPending = itinerariInPending;
        this.curatore = curatore;

    }
    public List<Evento> getEventi() {
        return eventi;
    }
    public List<Evento> getEventiInPending() {
        return eventiInPending;
    }

    public List<POI> getPOISInPending() {
        return POISInPending;
    }

    public List<POI> getPOIS() {
        return POIS;
    }

    public String getNome() {
        return nome;
    }

    public Curatore getCuratore() {
        return curatore;
    }

    public List<Itinerario> getItinerariInPending() {
        return ItinerariInPending;
    }

    public List<Itinerario> getItinerari() {
        return itinerari;
    }

    public int getID() {
        return ID;
    }
    public void addPoiInPending(POI poi){
        POISInPending.add(poi);
        curatore.verificaContenuto();
    }
    public void addItinerarioInPending(Itinerario itinerario){
        ItinerariInPending.add(itinerario);
        curatore.verificaContenuto();
    }
    public void addEventoInPending(Evento evento){
        eventiInPending.add(evento);
        curatore.verificaContenuto();
    }
    public void addPOI(POI poi){
        POIS.add(poi);
    }
    public void addEvento(Evento evento){
        eventi.add(evento);
    }
    public void addItinerario(Itinerario itinerario){
        itinerari.add(itinerario);
    }
}
