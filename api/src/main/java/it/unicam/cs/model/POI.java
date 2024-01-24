package it.unicam.cs.model;

import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.Tipo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
public abstract class POI {
    private final int ID;
    private final String nome;
    private final Posizione posizione;
    private String descrizione;
    private final LocalDateTime dataCreazione;
    private final int IDComune;
    private final List<ContenutoMultimediale> contenutiMultimediali;
    private final Tipo tipoPOI;
    private final int IDContributore;


    public POI(int ID, String nome, Posizione posizione, String descrizione,
               LocalDateTime dataCreazione,int IDComune, List<ContenutoMultimediale> contenutiMultimediali,
                Tipo tipoPOI, int IDContributore) {

        this.ID = ID;
        this.nome = nome;
        this.posizione = posizione;
        this.descrizione = descrizione;
        this.dataCreazione = dataCreazione;
        this.comuneAssociato=comuneAssociato;
        this.contenutiMultimediali = contenutiMultimediali;
        this.contenutiMultimedialiInPending=contenutiMultimedialiInPending;
        this.IDContributore = IDContributore;
        this.tipoPOI=tipoPOI;
        this.IDComune = IDComune;

    }

/* Metodi Get*/
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public Utente getUtenteAssociato() {
        return utenteAssociato;
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

    public Comune getComuneAssociato() {
        return comuneAssociato;
    }

    public List<ContenutoMultimediale> getContenutiMultimediali() {
        return contenutiMultimediali;
    }

    public List<ContenutoMultimediale> getContenutiMultimedialiInPending() {
        return contenutiMultimedialiInPending;
    }
    public Tipo getTipoPOI() {
        return tipoPOI;
    }
  
  public int getIDComune() {
        return IDComune;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POI poi = (POI) o;
        return ID == poi.ID && tipoPOI == poi.tipoPOI;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, tipoPOI);
    }

}
