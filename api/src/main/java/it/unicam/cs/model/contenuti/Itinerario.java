package it.unicam.cs.model.contenuti;


import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.POI;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/** La classe Itinerario rappresenta un percorso che collega più POI e può anche contenere contenuti multimediali **/
@Entity
public class Itinerario{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    private String descirizione;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contributore", referencedColumnName = "id")
    private Utente contributore;
    @ManyToOne
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private  List<POI> poisAssociati;

    public Itinerario(Integer id, String nome, Utente contributore,Comune comuneAssociato,
                      List<POI> poisAssociati, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.contributore = contributore;
        this.comuneAssociato = comuneAssociato;
        this.poisAssociati = poisAssociati;
        this.descirizione = descrizione;
    }

    public Itinerario() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Itinerario that = (Itinerario) o;
        return Objects.equals(poisAssociati, that.poisAssociati);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), poisAssociati);
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Utente getContributore() {
        return contributore;
    }

    public Comune getComuneAssociato() {
        return comuneAssociato;
    }

    public List<POI> getPoisAssociati() {
        return poisAssociati;
    }

    public String getDescirizione() {
        return descirizione;
    }
}
