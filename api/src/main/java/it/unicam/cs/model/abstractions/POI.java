package it.unicam.cs.model.abstractions;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.*;

import java.util.List;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class POI{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    @Embedded
    private Posizione posizione;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contributore", referencedColumnName = "id")
    private Utente contributore;
    @ManyToOne()
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    @Embedded
    private Indirizzo indirizzo;
    @OneToMany(mappedBy = "poiAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Evento> eventiAssociati;
    @OneToMany(mappedBy = "poiAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ContenutoMultimediale> contenutiMultimediali;


    public POI(Integer id, String nome,Posizione posizione, Utente contributore,
               Comune comuneAssociato, Indirizzo indirizzo, List<ContenutoMultimediale> contenutiMultimediali,
                List<Evento> eventiAssociati) {
        this.id = id;
        this.nome = nome;
        this.posizione = posizione;
        this.contributore = contributore;
        this.comuneAssociato = comuneAssociato;
        this.indirizzo = indirizzo;
        this.eventiAssociati = eventiAssociati;
        this.contenutiMultimediali = contenutiMultimediali;
    }

    public POI() {

    }


    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
       this.contenutiMultimediali.add(contenutoMultimediale);
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
}


