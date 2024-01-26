package it.unicam.cs.model;

import java.time.LocalDateTime;
import java.util.Objects;

/** L'interfaccia ContenutoMultimediale rappresenta un contenuto multimediale che può essere associato ad un POI o ad un itinerario **/

public class ContenutoMultimediale extends Contenuto{
    private final POI poiAssociato;

    public ContenutoMultimediale(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore, POI poiAssociato) {
        super(comuneAssociato, id, nome, utenteCreatore);
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
