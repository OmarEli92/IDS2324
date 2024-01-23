package it.unicam.cs.model;


import java.time.LocalDateTime;
import java.util.List;

/** La classe Evento rappresenta un evento che si svolge in un determinato giorno e in un determinato luogo **/
public abstract class Evento {
    private final int ID;
    private final String nome;
    private String descrizione;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
    private final int idContributore;
    private final int idPOIAssociato;
    private List<ContenutoMultimediale> contenutiMultimediali;

    public Evento(int ID, String nome, String descrizione, LocalDateTime dataInizio,
                  LocalDateTime dataFine, int idContributore, int idPOIAssociato,
                  List<ContenutoMultimediale> contenutiMultimediali) {
        this.ID = ID;
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.idContributore = idContributore;
        this.idPOIAssociato = idPOIAssociato;
        this.contenutiMultimediali = contenutiMultimediali;
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

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }

    public int getIdContributore() {
        return idContributore;
    }
}
