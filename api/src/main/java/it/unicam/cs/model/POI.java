package it.unicam.cs.model;

import it.unicam.cs.util.Posizione;
import java.time.LocalDateTime;
import java.util.List;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
public abstract class POI {
    private final int ID;
    private final String nome;
    private final Posizione posizione;
    private String descrizione;
    private final LocalDateTime dataCreazione;
    private final List<ContenutoMultimediale> contenutiMultimediali;
    private final int IDContributore;
    private String tipo; //TODO: da spostare nella classe concreta che estende POI


    private final int IDComune;



    public POI(int ID, String nome, Posizione posizione, String descrizione,
               LocalDateTime dataCreazione, List<ContenutoMultimediale> contenutiMultimediali,
               int IDContributore, int IDComune) {
        this.ID = ID;
        this.nome = nome;
        this.posizione = posizione;
        this.descrizione = descrizione;
        this.dataCreazione = dataCreazione;
        this.contenutiMultimediali = contenutiMultimediali;
        this.IDContributore = IDContributore;
        this.IDComune = IDComune;
    }

/* Metodi Get*/
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }



    public int getIDContributore() {
        return IDContributore;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public List<ContenutoMultimediale> getContenutiMultimediali() {
        return contenutiMultimediali;
    }

    public String getTipo() {
        return tipo;
    }


    public int getIDComune() {
        return IDComune;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
