package it.unicam.cs.model;

import it.unicam.cs.exception.POINotFoundException;

import java.util.List;
import java.util.Map;

public class Comune {
    private final String nome;
    private final int ID;
    private final List<POI> POIS;
    private final List<Itinerario> itinerari;
    private final List<Evento> eventi;
    private final List<Evento> eventiInPending;
    private final List<POI> POISInPending;
    private final List<Itinerario> ItinerariInPending;
    private final List<Utente> listaUtenti;
    private final Curatore curatore;
    private final int IDGestorePiattaforma;

    public Comune(String nome, int ID, List<POI> POIS, List<Itinerario> itinerari, List<Evento> eventi,
                  List<Evento> eventiInPending, List<POI> POISInPending, List<Itinerario> itinerariInPending,List<Utente>listaUtenti,
                  Curatore curatore, int IDGestorePiattaforma) {

        this.nome = nome;
        this.ID = ID;
        this.POIS = POIS; //TODO da rimodellare quando si integra spring e persistenta nel db
        this.itinerari = itinerari; //TODO stessa cosa per eventi ,itinerari
        this.eventi = eventi;
        this.eventiInPending = eventiInPending;
        this.POISInPending = POISInPending;
        this.ItinerariInPending = itinerariInPending;
        this.listaUtenti=listaUtenti;
        this.curatore = curatore;
        this.IDGestorePiattaforma = IDGestorePiattaforma;
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
   public int getIDGestorePiattaforma() {
        return IDGestorePiattaforma;
     
    public void verificaCoordinate(POI poi) throws POINotFoundException {
    //TODO
    }
}
