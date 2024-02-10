package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.util.Posizione;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Comune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "comuneAssociato")
    private List<POI> POIS;
    @OneToMany(mappedBy = "comuneAssociato")
    private List<Itinerario> itinerari;
    @OneToMany(mappedBy = "comuneAssociato")
    private List<Evento> eventi;
    @OneToMany(mappedBy = "comuneAssociato")
    private List<Evento> eventiInPending;
    @OneToMany(mappedBy = "comuneAssociato")
    private List<POI> POISInPending;
    @OneToMany(mappedBy = "comuneAssociato")
    private List<Itinerario> itinerariInPending;
    @OneToMany(mappedBy = "comuneAssociato")
    private List<Curatore> curatori;
    @OneToMany(mappedBy = "comuneAssociato")
    private List<Utente> listaUtenti;
    @OneToOne(fetch = FetchType.LAZY)
    private GestorePiattaforma gestorePiattaforma;

    public Comune(String nome, Integer id, List<POI> POIS, List<Itinerario> itinerari, List<Evento> eventi,
                  List<Evento> eventiInPending, List<POI> POISInPending, List<Itinerario> itinerariInPending,
                  List<Utente>listaUtenti, List<Curatore> curatori, GestorePiattaforma gestorePiattaforma) {

        this.nome = nome;
        this.id = id;
        this.POIS = POIS;

        this.itinerari = itinerari;
        this.eventi = eventi;
        this.eventiInPending = eventiInPending;
        this.POISInPending = POISInPending;
        this.itinerariInPending = itinerariInPending;
        this.listaUtenti=listaUtenti;
        this.curatori = curatori;
        this.gestorePiattaforma = gestorePiattaforma;
    }

    public Comune() {

    }

    public String getNome() {
        return nome;
    }


   public GestorePiattaforma getGestorePiattaforma() {
       return gestorePiattaforma;
   }


    public List<Curatore> getCuratori() {
        return curatori;
    }

    public Integer getId() {
        return id;
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
