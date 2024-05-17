package it.unicam.cs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.util.info.Posizione;
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
    @Embedded
    private Posizione posizione;
    private String provincia;
    private String regione;
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<POI> POIS;
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Itinerario> itinerari;
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Evento> eventi;
    @OneToMany(mappedBy = "comuneAssociato", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ContenutoMultimediale> contenutiMultimediali;
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Utente> curatori;
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Utente> listaUtenti;
    @OneToOne(fetch = FetchType.LAZY)
    private Utente gestoreComune;
    @ElementCollection
    @CollectionTable(name="perimetro_comune", joinColumns = @JoinColumn(name="id_comune"))
    private List<Posizione> perimetro = new ArrayList<>();

    public Comune(String nome, Integer id,String provincia,String regione,Posizione posizione, List<POI> POIS, List<Itinerario> itinerari, List<Evento> eventi,
                  List<Utente>listaUtenti, List<Utente> curatori, Utente gestoreComune) {


        this.nome = nome;
        this.id = id;
        this.provincia = provincia;
        this.regione = regione;
        this.POIS = POIS;
        this.posizione = posizione;
        this.itinerari = itinerari;
        this.eventi = eventi;
        this.listaUtenti=listaUtenti;
        this.curatori = curatori;
        this.gestoreComune = gestoreComune;
    }
    public Comune (String nome, List<Posizione> perimetro, Utente gestoreComune){
        this.nome = nome;
        this.perimetro = perimetro;
        this.gestoreComune = gestoreComune;
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


}
