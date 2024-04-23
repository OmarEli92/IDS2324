package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Entity
@Data
public final class Parco extends POI {
    private boolean presenzaSpecieProtetta;
    private String orarioApertura;
    private List<Itinerario> percorsi;
    private boolean presenzaAnimali;
    private int estensione;

    public Parco(String nome, Posizione posizione, Utente contributore, StatoElemento stato, Comune comuneAssociato, Indirizzo indirizzo, List<Evento> eventiAssociati, List<ContenutoMultimediale> contenutiMultimediali, boolean presenzaSpecieProtetta, String orarioApertura, List<Itinerario> percorsi, boolean presenzaAnimali, int estensione) {
        super(nome, posizione, contributore, stato, comuneAssociato, indirizzo, eventiAssociati, contenutiMultimediali);
        this.presenzaSpecieProtetta = presenzaSpecieProtetta;
        this.orarioApertura = orarioApertura;
        this.percorsi = percorsi;
        this.presenzaAnimali = presenzaAnimali;
        this.estensione = estensione;
    }
}
