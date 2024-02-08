package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;

import java.util.Objects;

/** L'interfaccia ContenutoMultimediale rappresenta un contenuto multimediale che può essere associato ad un POI o ad un itinerario **/

public class ContenutoMultimediale {
    private final int id;
    private String nome;
    private final Utente utenteCreatore;
    private final POI poiAssociato;

    public ContenutoMultimediale(int id, String nome, Utente utenteCreatore, POI poiAssociato) {
        this.id = id;
        this.nome = nome;
        this.utenteCreatore = utenteCreatore;
        this.poiAssociato = poiAssociato;
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
}
