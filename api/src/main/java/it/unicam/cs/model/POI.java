package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.enums.StatoContenuto;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class POI {
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
    private StatoContenuto statoContenuto;


    public POI( String nome,Posizione posizione,Utente contributore,
               Comune comuneAssociato, Indirizzo indirizzo, StatoContenuto statoContenuto) {
        //this.id = id;
        this.nome = nome;
        this.posizione = posizione;
        //this.tipo = tipo;
        this.contributore = contributore;
        this.comuneAssociato = comuneAssociato;
        this.indirizzo = indirizzo;
        this.statoContenuto=statoContenuto;

    }

    public POI() {

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


