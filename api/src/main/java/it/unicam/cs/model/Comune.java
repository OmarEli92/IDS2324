package it.unicam.cs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity @NoArgsConstructor @JsonIgnoreProperties(ignoreUnknown = true)
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
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Evento> eventiInPending;
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<POI> POISInPending;
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Itinerario> itinerariInPending;
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Utente> curatori;
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Utente> listaUtenti;
    @OneToOne(fetch = FetchType.LAZY)
    private Utente gestoreComune;

    public Comune(String nome, Integer id,String provincia,String regione,Posizione posizione, List<POI> POIS, List<Itinerario> itinerari, List<Evento> eventi,
                  List<Evento> eventiInPending, List<POI> POISInPending, List<Itinerario> itinerariInPending,
                  List<Utente>listaUtenti, List<Utente> curatori, Utente gestoreComune) {

        this.nome = nome;
        this.id = id;
        this.provincia = provincia;
        this.regione = regione;
        this.POIS = POIS;
        this.posizione = posizione;
        this.itinerari = itinerari;
        this.eventi = eventi;
        this.eventiInPending = eventiInPending;
        this.POISInPending = POISInPending;
        this.itinerariInPending = itinerariInPending;
        this.listaUtenti=listaUtenti;
        this.curatori = curatori;
        this.gestoreComune = gestoreComune;
    }



    public String getNome() {
        return nome;
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
