package it.unicam.cs.model;


import java.time.LocalDateTime;
import java.util.Objects;


/** La classe Evento rappresenta un evento che si svolge in un determinato giorno e in un determinato luogo **/
public abstract class Evento{
    private final int id;
    private final String nome;
    private final String descrizione;
    private final int idContributore;
    private final POI poiAssociato;
    private final LocalDateTime dataInizio;
    private final LocalDateTime dataFine;


    public Evento( int id, String nome,int idcomuneAssociato, String descrizione,
                   int idContributore, POI poiAssociato, LocalDateTime dataInizio,
                   LocalDateTime dataFine) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.idContributore = idContributore;
        this.poiAssociato = poiAssociato;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
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

    public POI getPoiAssociato() {
        return poiAssociato;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Evento evento = (Evento) o;
        return Objects.equals(poiAssociato, evento.poiAssociato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), poiAssociato);
    }


}
