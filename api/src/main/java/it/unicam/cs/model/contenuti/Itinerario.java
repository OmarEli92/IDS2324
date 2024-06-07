package it.unicam.cs.model.contenuti;


import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** La classe Itinerario rappresenta un percorso che collega più POI e può anche contenere contenuti multimediali **/
@Entity
@Getter
public class Itinerario{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    private String descrizione;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contributore", referencedColumnName = "id")
    private Utente contributore;
    @Enumerated(EnumType.STRING)
    private StatoElemento stato;
    @ManyToOne
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    @ManyToMany
    @JoinTable(name = "Pois",
    joinColumns = @JoinColumn(name = "itinerario_id"),
    inverseJoinColumns = @JoinColumn(name = "poi_id"))
    private  List<POI> poisAssociati;
    @OneToMany(mappedBy = "itinerarioAssociato", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContenutoMultimediale> contenutiMultimedialiAssociati = new ArrayList<>();

    public Itinerario(String nome, Utente contributore,StatoElemento stato,Comune comuneAssociato,
                      List<POI> poisAssociati, String descrizione) {
        this.nome = nome;
        this.contributore = contributore;
        this.stato = stato;
        this.comuneAssociato = comuneAssociato;
        this.poisAssociati = poisAssociati;
        this.descrizione = descrizione;
    }

    public Itinerario() {

    }

    public void setStato(StatoElemento stato) {
        this.stato = stato;
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
    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        this.contenutiMultimedialiAssociati.add(contenutoMultimediale);
    }


}
