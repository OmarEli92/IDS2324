package it.unicam.cs.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Objects;

/** La classe Itinerario rappresenta un percorso che collega più POI e può anche contenere contenuti multimediali **/
@Entity
public class Itinerario{
    @Id
    private  String id;
    private  String nome;
    private  String idContributore;
    private  String idComune;
    private  List<POI> poisAssociati;

    public Itinerario(String id, String nome, String idContributore,String idComune, List<POI> poisAssociati) {
        this.id = id;
        this.nome = nome;
        this.idContributore = idContributore;
        this.idComune = idComune;
        this.poisAssociati = poisAssociati;
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

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getIdContributore() {
        return idContributore;
    }

    public String getIdComune() {
        return idComune;
    }

    public List<POI> getPoisAssociati() {
        return poisAssociati;
    }
}
