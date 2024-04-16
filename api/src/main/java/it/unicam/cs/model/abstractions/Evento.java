package it.unicam.cs.model.abstractions;


import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


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

}

