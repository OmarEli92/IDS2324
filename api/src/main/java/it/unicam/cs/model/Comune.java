package it.unicam.cs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity @Data
@NoArgsConstructor @JsonIgnoreProperties(ignoreUnknown = true)
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
    private List<Utente> curatori;
    @OneToMany(mappedBy = "comuneAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Utente> listaUtenti;
    @OneToOne(fetch = FetchType.LAZY)
    private Utente gestoreComune;

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




}
