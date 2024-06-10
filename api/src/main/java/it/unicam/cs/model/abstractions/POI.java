package it.unicam.cs.model.abstractions;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.enums.TipoPOI;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class POI{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    @Embedded
    private Posizione posizione;
    @Enumerated(EnumType.STRING)
    private TipoPOI tipoPOI;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contributore", referencedColumnName = "id")
    private Utente contributore;
    @Enumerated(EnumType.STRING)
    private StatoElemento stato;
    @ManyToOne()
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    @Embedded
    private Indirizzo indirizzo;
    @OneToMany(mappedBy = "poiAssociato",cascade = CascadeType.ALL)
    private List<Evento> eventiAssociati;
    @OneToMany(mappedBy = "poiAssociato",cascade = CascadeType.ALL)
    private List<ContenutoMultimediale> contenutiMultimediali;
    @OneToMany(mappedBy = "poiAssociato", cascade = CascadeType.ALL)
    private List<Contest> contestAssociati;
    @ManyToMany(mappedBy = "poisAssociati")
    private List<Itinerario> itinerariAssociati;

    public POI(String nome, Posizione posizione, TipoPOI tipoPOI, Utente contributore, StatoElemento stato, Comune comuneAssociato, Indirizzo indirizzo, List<Evento> eventiAssociati, List<ContenutoMultimediale> contenutiMultimediali) {
        this.nome = nome;
        this.posizione = posizione;
        this.tipoPOI = tipoPOI;
        this.contributore = contributore;
        this.stato = stato;
        this.comuneAssociato = comuneAssociato;
        this.indirizzo = indirizzo;
        this.eventiAssociati = eventiAssociati;
        this.contenutiMultimediali = contenutiMultimediali;
    }

    public void setStato(StatoElemento stato) {
        this.stato = stato;
    }

    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        this.contenutiMultimediali.add(contenutoMultimediale);
    }
    public void aggiungiEvento(Evento evento){
        this.eventiAssociati.add(evento);
    }
    public void rimuoviContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale){
       this.contenutiMultimediali.remove(contenutoMultimediale);
    }

    public List<ContenutoMultimediale> getContenutiMultimediali() {
        return contenutiMultimediali;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public Utente getContributore() {
        return contributore;
    }

    public Comune getComuneAssociato() {
        return comuneAssociato;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public List<Evento> getEventiAssociati() {
        return eventiAssociati;
    }

        public void aggiungiContest(Contest contest){
        this.contestAssociati.add(contest);
    }
}


