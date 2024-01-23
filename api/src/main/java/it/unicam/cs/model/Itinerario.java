package it.unicam.cs.model;


import it.unicam.cs.util.Tipo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/** La classe Itinerario rappresenta un percorso che collega più POI e può anche contenere contenuti multimediali **/
public class Itinerario {
    private final int ID;
    private final String nome;
    private final String descrizione;
    private final List<POI> puntiDiInteresse;
    private final LocalDateTime dataCreazione;
    private final Utente utenteAssociato;
    private final Comune comuneAssociato;

    public Itinerario(int ID, String nome, String descrizione, List<POI> puntiDiInteresse,
                      LocalDateTime dataCreazione,
                      Utente utenteAssociato, Comune comuneAssociato) {
        this.ID = ID;
        this.nome = nome;
        this.descrizione = descrizione;
        this.puntiDiInteresse = puntiDiInteresse;
        this.dataCreazione = dataCreazione;
        this.utenteAssociato = utenteAssociato;
        this.comuneAssociato=comuneAssociato;
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

    public Utente getUtenteAssociato() {
        return utenteAssociato;
    }
    public Comune getComuneAssociato() {
        return comuneAssociato;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Itinerario that = (Itinerario) o;
        return ID == that.ID && Objects.equals(puntiDiInteresse, that.puntiDiInteresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, puntiDiInteresse);
    }
}
