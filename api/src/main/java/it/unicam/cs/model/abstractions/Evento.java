package it.unicam.cs.model.abstractions;


import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


/** La classe Evento rappresenta un evento che si svolge in un determinato giorno e in un determinato luogo **/
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public abstract class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    private String nome;
    private String descrizione;
    private boolean aperto;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contributore", referencedColumnName = "id")
    private Utente contributore;
    @Enumerated(EnumType.STRING)
    private StatoElemento stato;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_poi_associato", referencedColumnName = "id")
    private POI poiAssociato;
    @Column(name = "data_inizio")
    private LocalDateTime dataInizio;
    @Column(name = "data_fine")
    private LocalDateTime dataFine;
    @OneToMany(mappedBy = "eventoAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ContenutoMultimediale> contenutiMultimediali;

    public Evento(Comune comuneAssociato, String nome, String descrizione, boolean aperto, TipoEvento tipoEvento, Utente contributore, StatoElemento stato,POI poiAssociato, LocalDateTime dataInizio, LocalDateTime dataFine, List<ContenutoMultimediale> contenutiMultimediali) {
        this.comuneAssociato = comuneAssociato;
        this.nome = nome;
        this.descrizione = descrizione;
        this.aperto = aperto;
        this.tipoEvento = tipoEvento;
        this.contributore = contributore;
        this.stato = stato;
        this.poiAssociato = poiAssociato;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.contenutiMultimediali = contenutiMultimediali;
    }

    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        this.contenutiMultimediali.add(contenutoMultimediale);
    }
}

