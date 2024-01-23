package it.unicam.cs.model;


import java.time.LocalDateTime;
import java.util.List;

/** La classe Itinerario rappresenta un percorso che collega più POI e può anche contenere contenuti multimediali **/
public class Itinerario {
    private final int ID;
    private final String nome;
    private final String descrizione;
    private final List<POI> puntiDiInteresse;
    private final LocalDateTime dataCreazione;
    private final List<ContenutoMultimediale> contenutiMultimediali;
    private final int IDContributore;
    private final int idComune;
    public Itinerario(int ID, String nome, String descrizione, List<POI> puntiDiInteresse,
                      LocalDateTime dataCreazione, List<ContenutoMultimediale> contenutiMultimediali,
                      int IDContributore,int idComune){
        this.ID = ID;
        this.nome = nome;
        this.descrizione = descrizione;
        this.puntiDiInteresse = puntiDiInteresse;
        this.dataCreazione = dataCreazione;
        this.contenutiMultimediali = contenutiMultimediali;
        this.IDContributore = IDContributore;
        this.idComune = idComune;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public List<POI> getPuntiDiInteresse() {
        return puntiDiInteresse;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public List<ContenutoMultimediale> getContenutiMultimediali() {
        return contenutiMultimediali;
    }

    public int getIDContributore() {
        return IDContributore;
    }

    public int getIdComune() {
        return idComune;
    }
}
