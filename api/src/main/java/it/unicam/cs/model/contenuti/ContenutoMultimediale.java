package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import jakarta.persistence.*;

import java.util.Objects;

/** L'interfaccia ContenutoMultimediale rappresenta un contenuto multimediale che può essere associato ad un POI o ad un itinerario **/
@Entity
public class ContenutoMultimediale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    @ManyToOne(fetch = FetchType.LAZY)
    private Utente utenteCreatore;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_poi_associato", referencedColumnName = "id")
    private POI poiAssociato;
    @ManyToOne
    @JoinColumn(name = "id_evento_associato", referencedColumnName = "id")
    private Evento eventoAssociato;

    public ContenutoMultimediale(int id, String nome, Utente utenteCreatore, POI poiAssociato) {
        this.id = id;
        this.nome = nome;
        this.utenteCreatore = utenteCreatore;
        this.poiAssociato = poiAssociato;
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

    public POI getPoiAssociato() {
        return poiAssociato;
    }
}
