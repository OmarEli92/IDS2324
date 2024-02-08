package it.unicam.cs.model;


import java.time.LocalDateTime;
import java.util.Objects;


/** La classe Evento rappresenta un evento che si svolge in un determinato giorno e in un determinato luogo **/
public abstract class Evento {
    private final String id;
    private final String idcomuneAssociato;
    private final String nome;
    private final String descrizione;
    private final String idContributore;
    private final String idPoiAssociato;
    private final LocalDateTime dataInizio;
    private final LocalDateTime dataFine;


    public Evento(String id, String nome, String idcomuneAssociato, String descrizione,
                  String idContributore, String idPoiAssociato, LocalDateTime dataInizio,
                  LocalDateTime dataFine) {
        this.id = id;
        this.nome = nome;
        this.idcomuneAssociato = idcomuneAssociato;
        this.descrizione = descrizione;
        this.idContributore = idContributore;
        this.idPoiAssociato = idPoiAssociato;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public String getId() {
        return id;
    }

    public String getIdcomuneAssociato() {
        return idcomuneAssociato;
    }

    public String getNome() {
        return nome;
    }

    public String getIdContributore() {
        return idContributore;
    }

    public String getIdPoiAssociato() {
        return idPoiAssociato;
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

}

