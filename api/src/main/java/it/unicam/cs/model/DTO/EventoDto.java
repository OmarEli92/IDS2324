package it.unicam.cs.model.DTO;

import it.unicam.cs.util.info.Posizione;


/** La classe EventoDto è un Data Transfer Object per la classe Evento serve principlamente per ottenere

 * solo le informazioni principali sull'evento nel territorio quali id,nome,posizione,idComune e idContributore
 * senza dover scaricare tutte le informazioni relative ad un evento del territorio
 * **/
public class EventoDto{
    private Integer ID;
    private String nome;
    private Posizione posizione;
    private String descrizione;
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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

