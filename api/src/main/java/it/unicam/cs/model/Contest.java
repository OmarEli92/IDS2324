package it.unicam.cs.model;

import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.abstractions.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Contest {
    @Id
    private Integer id;
    private String oggetto;
    private String descrizione;
    @Column(name = "data_inizio")
    private Date dataInizio;
    @Column(name = "data_fine")
    private Date dataFine;
    @OneToOne
    private POI luogo;
    private int partecipanti;
    @OneToMany
    private List<ContenutoMultimediale> contenutiCaricati;
    @OneToOne
    private ContenutoMultimediale contenutoVincitore;
    @OneToOne
    private Utente organizzatore;

    public Contest() {
    }

}
