package it.unicam.cs.model;


import java.util.List;
import java.util.Objects;

/** La classe Itinerario rappresenta un percorso che collega più POI e può anche contenere contenuti multimediali **/
public class Itinerario{
    private final int id;
    private final String nome;
    private final int idContributore;
    private final int idComune;
    private final List<POI> poisAssociati;

    public Itinerario(int id, String nome, int idContributore,int idComune, List<POI> poisAssociati) {
        this.id = id;
        this.nome = nome;
        this.idContributore = idContributore;
        this.idComune = idComune;
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

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdContributore() {
        return idContributore;
    }

    public int getIdComune() {
        return idComune;
    }

    public List<POI> getPoisAssociati() {
        return poisAssociati;
    }
}
