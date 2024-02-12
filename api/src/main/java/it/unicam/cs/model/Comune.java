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
    @Embedded
    private Posizione posizione;
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

    public Comune(String nome, Integer id,Posizione posizione, List<POI> POIS, List<Itinerario> itinerari, List<Evento> eventi,
                  List<Evento> eventiInPending, List<POI> POISInPending, List<Itinerario> itinerariInPending,
                  List<Utente>listaUtenti, List<Curatore> curatori, GestorePiattaforma gestorePiattaforma) {

        this.nome = nome;
        this.id = id;
        this.POIS = POIS;
        this.posizione = posizione;
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

}
