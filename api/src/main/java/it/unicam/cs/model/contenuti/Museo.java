package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.CollezioniMuseo;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.info.Contatti;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data

public final class Museo extends POI {
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;
    private int numeroSale;
    private List<CollezioniMuseo> collezioni;

    public Museo(Integer id, String nome, Posizione posizione, Utente contributore, StatoElemento stato, Comune comuneAssociato, Indirizzo indirizzo, List<Evento> eventiAssociati, List<ContenutoMultimediale> contenutiMultimediali, String orariApertura, String responsabile, Contatti contatti, int numeroSale, List<CollezioniMuseo> collezioni) {
        super(id, nome, posizione, contributore, stato, comuneAssociato, indirizzo, eventiAssociati, contenutiMultimediali);
        this.orariApertura = orariApertura;
        this.responsabile = responsabile;
        this.contatti = contatti;
        this.numeroSale = numeroSale;
        this.collezioni = collezioni;
    }
}
