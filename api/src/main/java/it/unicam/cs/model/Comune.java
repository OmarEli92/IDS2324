package it.unicam.cs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.util.info.Posizione;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity @NoArgsConstructor @JsonIgnoreProperties(ignoreUnknown = true) @Data
public class Comune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String provincia;
    private String regione;
    @Embedded
    private Posizione posizione;
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL)
    private List<POI> POIS = new ArrayList<>();
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL)
    private List<Itinerario> itinerari = new ArrayList<>();
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL)
    private List<Evento> eventi = new ArrayList<>();
    @OneToMany(mappedBy = "comuneAssociato", cascade = CascadeType.ALL)
    private List<ContenutoMultimediale> contenutiMultimediali = new ArrayList<>();
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL)
    private List<Utente> curatori = new ArrayList<>();
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL)
    private List<Utente> listaUtenti = new ArrayList<>();
    @OneToMany(mappedBy = "comuneAssociato", cascade = CascadeType.ALL)
    private List<Contest> listaContest = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY)
    private Utente gestoreComune;
    @ElementCollection
    @CollectionTable(name="perimetro_comune", joinColumns = @JoinColumn(name="id_comune"))
    private List<Posizione> perimetro = new ArrayList<>();

    public Comune(String nome, Integer id,String provincia,String regione, Posizione posizione, List<POI> POIS, List<Itinerario> itinerari, List<Evento> eventi,
                  List<Utente>listaUtenti, List<Utente> curatori, Utente gestoreComune, List<Contest> listaContest) {
        this.nome = nome;
        this.id = id;
        this.provincia = provincia;
        this.regione = regione;
        this.posizione = posizione;
        this.POIS = POIS;
        this.itinerari = itinerari;
        this.eventi = eventi;
        this.listaUtenti=listaUtenti;
        this.curatori = curatori;
        this.gestoreComune = gestoreComune;
        this.listaContest = listaContest;
    }
    public Comune (String nome, Utente gestoreComune, Posizione posizione, List<Posizione> perimetro){
        this.nome = nome;
        this.gestoreComune = gestoreComune;
        this.posizione = posizione;
        this.perimetro = perimetro;
    }

    public void aggiungiPOI(POI poi){
        this.POIS.add(poi);
    }
    public void aggiugniItinerario(Itinerario itinerario){
        this.itinerari.add(itinerario);
    }
    public void aggiungiEvento(Evento evento){ this.eventi.add(evento); }
    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
            this.contenutiMultimediali.add(contenutoMultimediale);
        }

   public Utente getGestoreComune() {
       return gestoreComune;
   }


    public List<Utente> getCuratori() {
        return curatori;
    }

    public Integer getId() {
        return id;
    }


    public void aggiungiContest(Contest contest) {
        this.listaContest.add(contest);
    }
    public void aggiungiUtente(Utente utente){ this.listaUtenti.add(utente);}
    public void aggiungiCuratore (Utente curatore){ this.curatori.add(curatore);}
}
