package it.unicam.cs.model;

import it.unicam.cs.util.Posizione;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
public class POI {
    private final int ID;
    private final String nome;
    private final Posizione posizione;
    private final String descrizione;
    private final LocalDateTime dataCreazione;
    private final List<ContenutoMultimediale> contenutiMultimediali;
    private final int IDContributore;


    public POI(int ID, String nome, Posizione posizione, String descrizione,
               LocalDateTime dataCreazione, List<ContenutoMultimediale> contenutiMultimediali,
               int IDContributore) {
        this.ID = ID;
        this.nome = nome;
        this.posizione = posizione;
        this.descrizione = descrizione;
        this.dataCreazione = dataCreazione;
        this.contenutiMultimediali = contenutiMultimediali;
        this.IDContributore = IDContributore;
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
}
