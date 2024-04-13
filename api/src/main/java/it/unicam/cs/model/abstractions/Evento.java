package it.unicam.cs.model.abstractions;


import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import jakarta.persistence.*;

import java.time.LocalDateTime;


/** La classe Evento rappresenta un evento che si svolge in un determinato giorno e in un determinato luogo **/
@Entity
public abstract class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    private String nome;
    private String descrizione;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contributore", referencedColumnName = "id")
    private Utente contributore;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_poi_associato", referencedColumnName = "id")
    private POI poiAssociato;
    @Column(name = "data_inizio")
    private LocalDateTime dataInizio;
    @Column(name = "data_fine")
    private LocalDateTime dataFine;
    private String tipo;


    public Evento(Integer id, String nome, Comune idcomuneAssociato, String descrizione,
                  Utente contributore, POI poiAssociato, LocalDateTime dataInizio,
                  LocalDateTime dataFine,String tipo) {
        this.id = id;
        this.nome = nome;
        this.comuneAssociato = comuneAssociato;
        this.descrizione = descrizione;
        this.contributore = contributore;
        this.poiAssociato = poiAssociato;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }
}
