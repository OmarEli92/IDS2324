package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.ServiziUtili;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.info.Contatti;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
public final class POIServiziUtili extends POI {
    private ServiziUtili servizio;
    private Contatti contatti;
    private String orariApertura;

    public POIServiziUtili(Integer id, String nome, Posizione posizione, Utente contributore, StatoElemento stato, Comune comuneAssociato, Indirizzo indirizzo, List<Evento> eventiAssociati, List<ContenutoMultimediale> contenutiMultimediali, ServiziUtili servizio, Contatti contatti, String orariApertura) {
        super(id, nome, posizione, contributore, stato, comuneAssociato, indirizzo, eventiAssociati, contenutiMultimediali);
        this.servizio = servizio;
        this.contatti = contatti;
        this.orariApertura = orariApertura;
    }
}
