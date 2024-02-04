package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Evento;
import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.model.Abstractions.UtenteAutorizzato;
import it.unicam.cs.util.Posizione;

import java.util.List;

public class Comune {
    private final String nome;
    private final int ID;
    private final List<POI> POIS;
    private final List<Itinerario> itinerari;
    private final List<Evento> eventi;
    private final List<Evento> eventiInPending;
    private final List<POI> POISInPending;
    private final List<Itinerario> itinerariInPending;
    private final List<UtenteAutorizzato> listaUtenti;
    private final Curatore curatore;
    private final int IDGestorePiattaforma;

    public Comune(String nome, int ID, List<POI> POIS, List<Itinerario> itinerari, List<Evento> eventi,
                  List<Evento> eventiInPending, List<POI> POISInPending, List<Itinerario> itinerariInPending,List<UtenteAutorizzato>listaUtenti,
                  Curatore curatore, int IDGestorePiattaforma) {

        this.nome = nome;
        this.ID = ID;
        this.POIS = POIS; //TODO da rimodellare quando si integra spring e persistenta nel db
        this.itinerari = itinerari; //TODO stessa cosa per eventi ,itinerari
        this.eventi = eventi;
        this.eventiInPending = eventiInPending;
        this.POISInPending = POISInPending;
        this.itinerariInPending = itinerariInPending;
        this.listaUtenti=listaUtenti;
        this.curatore = curatore;
        this.IDGestorePiattaforma = IDGestorePiattaforma;
    }
    public String getNome() {
        return nome;
    }

    public Curatore getCuratore() {
        return curatore;
    }

    public int getID() {
        return ID;
    }
   public int getIDGestorePiattaforma() {
       return IDGestorePiattaforma;
   }
    public void verificaCoordinate (Posizione posizione)  {
    //TODO
    }

    public void aggiungiEvento (Evento evento){
        this.eventi.add(evento);
    }

    public void aggiungiEventoInPending(Evento evento){
        this.eventiInPending.add(evento);
    }
    public void rimuoviEventoInPending (Evento evento){
        this.eventiInPending.remove(evento);
    }
    public void aggiungiPOI(POI poi){
        this.POISInPending.add(poi);
    }

    public void aggiungiPOIInPending(POI poi) {
    this.POIS.add(poi);
    }

    public void rimoviPOIInPending(POI poi) {
    this.POISInPending.remove(poi);
    }

    public void aggiungiItinerario(Itinerario itinerario){
        this.itinerari.add(itinerario);
    }
    public void aggiungiItinerarioInPending(Itinerario itinerario){
        this.itinerariInPending.add(itinerario);
    }
    public void rimuoviItinerartioInPending(Itinerario itinerario){
        this.itinerariInPending.remove(itinerario);
    }

}
