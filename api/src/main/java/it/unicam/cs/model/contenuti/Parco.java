package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.enums.TipoPOI;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
public final class Parco extends POI {
    private boolean presenzaSpecieProtetta;
    private String orarioApertura;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Itinerario> percorsi;
    private boolean presenzaAnimali;
    private int estensione;

    public Parco(String nome, Posizione posizione, TipoPOI tipoPOI,Utente contributore, StatoElemento stato, Comune comuneAssociato, List<Evento> eventiAssociati, List<ContenutoMultimediale> contenutiMultimediali, boolean presenzaSpecieProtetta, String orarioApertura, List<Itinerario> percorsi, boolean presenzaAnimali, int estensione) {
        super(nome, posizione, tipoPOI, contributore, stato, comuneAssociato, eventiAssociati, contenutiMultimediali);
        this.presenzaSpecieProtetta = presenzaSpecieProtetta;
        this.orarioApertura = orarioApertura;
        this.percorsi = percorsi;
        this.presenzaAnimali = presenzaAnimali;
        this.estensione = estensione;
    }
}
