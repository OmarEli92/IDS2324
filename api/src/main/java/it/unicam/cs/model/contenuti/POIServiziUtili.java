package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.ServiziUtili;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.enums.TipoPOI;
import it.unicam.cs.util.info.Contatti;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
public final class POIServiziUtili extends POI {
    private ServiziUtili servizio;
    @Embedded
    private Contatti contatti;
    private String orariApertura;

    public POIServiziUtili(String nome, Posizione posizione, TipoPOI tipoPOI, Utente contributore, StatoElemento stato, Comune comuneAssociato, Indirizzo indirizzo, List<Evento> eventiAssociati, List<ContenutoMultimediale> contenutiMultimediali, ServiziUtili servizio, Contatti contatti, String orariApertura) {
        super(nome, posizione, tipoPOI, contributore, stato, comuneAssociato, indirizzo, eventiAssociati, contenutiMultimediali);
        this.servizio = servizio;
        this.contatti = contatti;
        this.orariApertura = orariApertura;
    }
}
