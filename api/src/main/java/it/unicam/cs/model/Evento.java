package it.unicam.cs.model;


import it.unicam.cs.model.Abstractions.Utente;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;


/** La classe Evento rappresenta un evento che si svolge in un determinato giorno e in un determinato luogo **/
@Entity
public abstract class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    private String nome;
    private String descrizione;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contributore", referencedColumnName = "id")
    private Utente contributore;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_poi_associato", referencedColumnName = "id")
    private POI poiAssociato;
    @Column(name = "data_inizio")
    private LocalDateTime dataInizio;
    @Column(name = "data_fine")
    private LocalDateTime dataFine;


    public Evento(Integer id, String nome, Comune idcomuneAssociato, String descrizione,
                  Utente contributore, POI poiAssociato, LocalDateTime dataInizio,
                  LocalDateTime dataFine) {
        this.id = id;
        this.nome = nome;
        this.comuneAssociato = comuneAssociato;
        this.descrizione = descrizione;
        this.contributore = contributore;
        this.poiAssociato = poiAssociato;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Evento() {

    }

    public Integer getId() {
        return id;
    }

    public Comune getComuneAssociato() {
        return comuneAssociato;
    }

    public String getNome() {
        return nome;
    }

    public Utente getContributore() {
        return contributore;
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
        Evento evento = (Evento) o;
        return Objects.equals(id, evento.id) && Objects.equals(comuneAssociato, evento.comuneAssociato) && Objects.equals(poiAssociato, evento.poiAssociato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comuneAssociato, poiAssociato);
    }
}

