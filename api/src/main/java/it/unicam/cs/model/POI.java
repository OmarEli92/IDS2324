package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class POI extends Contenuto{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    @Embedded
    private Posizione posizione;
    private String tipo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contributore", referencedColumnName = "id")
    private Utente contributore;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    @Embedded
    private Indirizzo indirizzo;
    @OneToMany(mappedBy = "poiAssociato")
    private List<Evento> eventiAssociati;
    @OneToMany(mappedBy = "poiAssociato")
    private List<ContenutoMultimediale> contenutiMultimediali;
    @OneToMany(mappedBy = "poiAssociato")
    private List<ContenutoMultimediale> contenutiMultimedialiInPending;


    public POI(Integer id, String nome,Posizione posizione, String tipo, Utente contributore,
               Comune comuneAssociato, Indirizzo indirizzo, List<ContenutoMultimediale> contenutiMultimediali,
               List<ContenutoMultimediale> contenutiMultimedialiInPending, List<Evento> eventiAssociati) {
        this.id = id;
        this.nome = nome;
        this.posizione = posizione;
        this.tipo = tipo;
        this.contributore = contributore;
        this.comuneAssociato = comuneAssociato;
        this.indirizzo = indirizzo;
        this.eventiAssociati = eventiAssociati;
        this.contenutiMultimediali=contenutiMultimediali;
        this.contenutiMultimedialiInPending=contenutiMultimedialiInPending;
    }

    public POI() {

    }


    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
       this.contenutiMultimediali.add(contenutoMultimediale);
    }

    public void aggiungiContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale) {
        this.contenutiMultimedialiInPending.add(contenutoMultimediale);
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

    public String getTipo() {
        return tipo;
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

    public List<ContenutoMultimediale> getContenutiMultimedialiInPending() {
        return contenutiMultimedialiInPending;
    }

    public List<Evento> getEventiAssociati() {
        return eventiAssociati;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POI poi = (POI) o;
        return Objects.equals(posizione, poi.posizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posizione);
    }
}


