package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.util.enums.TipoContenutoMultimediale;
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
    @Enumerated(EnumType.STRING)
    private TipoContenutoMultimediale tipo;
    @Column(name = "Foto", nullable = true)
    private String foto;
    @Column(name = "Link", nullable = true)
    private String link;


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
