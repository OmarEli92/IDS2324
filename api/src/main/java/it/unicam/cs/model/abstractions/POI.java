package it.unicam.cs.model.abstractions;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class POI{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    @Embedded
    private Posizione posizione;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contributore", referencedColumnName = "id")
    private Utente contributore;
    private StatoElemento stato;
    @ManyToOne()
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    @Embedded
    private Indirizzo indirizzo;
    @OneToMany(mappedBy = "poiAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Evento> eventiAssociati;
    @OneToMany(mappedBy = "poiAssociato",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ContenutoMultimediale> contenutiMultimediali;

}


