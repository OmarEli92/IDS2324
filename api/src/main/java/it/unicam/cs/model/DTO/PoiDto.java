package it.unicam.cs.model.DTO;

import it.unicam.cs.util.info.Posizione;

/** La classe PoiDTO è un Data Transfer Object per la classe Itinerario serve principlamente per ottenere
 * solo le informazioni principali sul POI del territorio quali id,nome,posizione,idComune e idContributore
 * senza dover scaricare tutte le informazioni relative ad un POI del territorio**/
public class PoiDto{
    private Integer ID;
    private String nome;
    private Posizione posizione;
    private Integer IDComune;
    private Integer IDContributore;
    private String tipo;
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    public Integer getIDComune() {
        return IDComune;
    }

    public void setIDComune(Integer IDComune) {
        this.IDComune = IDComune;
    }

    public Integer getIDContributore() {
        return IDContributore;
    }

    public void setIDContributore(Integer IDContributore) {
        this.IDContributore = IDContributore;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
