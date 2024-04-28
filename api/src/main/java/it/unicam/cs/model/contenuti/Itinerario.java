package it.unicam.cs.model.contenuti;


import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/** La classe Itinerario rappresenta un percorso che collega più POI e può anche contenere contenuti multimediali **/
@Entity
@Data
public class Itinerario{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    private String descirizione;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contributore", referencedColumnName = "id")
    private Utente contributore;
    private StatoElemento stato;
    @ManyToOne
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private  List<POI> poisAssociati;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContenutoMultimediale> contenutiMultimedialiAssociati;

    public Itinerario(Integer id, String nome, Utente contributore,StatoElemento stato,Comune comuneAssociato,
                      List<POI> poisAssociati, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.contributore = contributore;
        this.stato = stato;
        this.comuneAssociato = comuneAssociato;
        this.poisAssociati = poisAssociati;
        this.descirizione = descrizione;
    }

    public Itinerario() {

    }

    public void setStato(Utente utente) {
        for(Ruolo ruolo : utente.getRuoli()){
            if(ruolo.getNome().equalsIgnoreCase("Curatore") || ruolo.getNome().equalsIgnoreCase("Contributore_Autorizzato")) {
                this.stato = StatoElemento.PUBBLICATO;
            }
            else if (ruolo.getNome().equalsIgnoreCase("Contributore")) {
                this.stato = StatoElemento.PENDING;
            }
        }
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
