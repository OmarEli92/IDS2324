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
    private final List<Curatore> listaCuratori;

    public Comune(String nome, int ID, List<POI> POIS, List<Itinerario> itinerari, List<Evento> eventi,
                  List<Evento> eventiInPending, List<POI> POISInPending, List<Itinerario> itinerariInPending,
                  List<Curatore> listaCuratori) {
        this.nome = nome;
        this.ID = ID;
        this.POIS = POIS;
        this.itinerari = itinerari;
        this.eventi = eventi;
        this.eventiInPending = eventiInPending;
        this.POISInPending = POISInPending;
        this.ItinerariInPending = itinerariInPending;
        this.listaCuratori = listaCuratori;

    }

}
