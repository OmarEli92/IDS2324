package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.enums.TipoAmministrativo;
import it.unicam.cs.util.info.Contatti;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class POIAmministrativo extends POI {
    private TipoAmministrativo tipo;
    private String orariApertura;
    private String responsabile;
    @Embedded
    private Contatti contatti;

    public POIAmministrativo(Integer id, String nome, Posizione posizione, Utente contributore, StatoElemento stato, Comune comuneAssociato, Indirizzo indirizzo, List<Evento> eventiAssociati, List<ContenutoMultimediale> contenutiMultimediali, TipoAmministrativo tipo, String orariApertura, String responsabile, Contatti contatti) {
        super(id, nome, posizione, contributore, stato, comuneAssociato, indirizzo, eventiAssociati, contenutiMultimediali);
        this.tipo = tipo;
        this.orariApertura = orariApertura;
        this.responsabile = responsabile;
        this.contatti = contatti;
    }
}

