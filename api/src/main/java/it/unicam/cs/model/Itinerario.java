package it.unicam.cs.model;


import it.unicam.cs.model.Abstractions.UtenteAutenticato;

import java.util.List;
import java.util.Objects;

/** La classe Itinerario rappresenta un percorso che collega più POI e può anche contenere contenuti multimediali **/
public class Itinerario extends Contenuto{
    private final List<POI> poisAssociati;

    public Itinerario(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore, List<POI> poisAssociati) {
        super(comuneAssociato, id, nome, utenteCreatore);
        this.poisAssociati = poisAssociati;
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

    public List<POI> getPoisAssociati() {
        return poisAssociati;
    }
}
