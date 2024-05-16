package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.enums.TipoContenuto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;

/** L'interfaccia ContenutoMultimediale rappresenta un contenuto multimediale che può essere associato ad un POI o ad un itinerario **/
@Entity
@Getter
public class ContenutoMultimediale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    @ManyToOne(fetch = FetchType.LAZY)
    private Utente utenteCreatore;
    private StatoElemento stato;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_poi_associato", referencedColumnName = "id")
    private POI poiAssociato;
    @ManyToOne
    @JoinColumn(name = "id_evento_associato", referencedColumnName = "id")
    private Evento eventoAssociato;
    @ManyToOne
    @JoinColumn(name = "id_itinerario_associato", referencedColumnName = "id")
    private Itinerario itinerarioAssociato;
    @ManyToOne
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;

    public ContenutoMultimediale(String nome, Utente utenteCreatore, StatoElemento stato, POI poiAssociato,Comune comuneAssociato) {
        this.nome = nome;
        this.utenteCreatore = utenteCreatore;
        this.stato = stato;
        this.poiAssociato = poiAssociato;
        this.comuneAssociato=comuneAssociato;
    }
    public ContenutoMultimediale(String nome, Utente utenteCreatore, StatoElemento stato, Evento eventoAssociato, Comune comuneAssociato) {
        this.nome = nome;
        this.utenteCreatore = utenteCreatore;
        this.stato = stato;
        this.eventoAssociato = eventoAssociato;
        this.comuneAssociato=comuneAssociato;
    }
    public ContenutoMultimediale(String nome, Utente utenteCreatore, StatoElemento stato, Itinerario itinerarioAssociato, Comune comuneAssociato) {
        this.nome = nome;
        this.utenteCreatore = utenteCreatore;
        this.stato = stato;
        this.itinerarioAssociato = itinerarioAssociato;
        this.comuneAssociato=comuneAssociato;
    }

    public ContenutoMultimediale() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ContenutoMultimediale that = (ContenutoMultimediale) o;
        return Objects.equals(poiAssociato, that.poiAssociato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), poiAssociato);
    }

    public void setStato(StatoElemento stato) {
        this.stato = stato;
    }
}
