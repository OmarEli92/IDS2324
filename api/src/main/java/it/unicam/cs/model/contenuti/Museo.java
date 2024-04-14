package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.CollezioniMuseo;
import it.unicam.cs.util.info.Contatti;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;
@Entity
@Data
public final class Museo extends POI {
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;
    private int numeroSale;
    private List<CollezioniMuseo> collezioni;
    public Museo(Integer id, String nome, Posizione posizione,
                 Utente contributore, Comune comuneAssociato, Indirizzo indirizzo,
                 List contenutiMultimediali, List eventiAssociati,
                 String orariApertura, String responsabile, Contatti contatti, int numeroSale, List<CollezioniMuseo> collezioni) {
        super(id, nome, posizione, contributore, comuneAssociato, indirizzo, contenutiMultimediali,
                eventiAssociati);
        this.orariApertura = orariApertura;
        this.responsabile = responsabile;
        this.contatti = contatti;
        this.numeroSale = numeroSale;
        this.collezioni = collezioni;
    }

}
