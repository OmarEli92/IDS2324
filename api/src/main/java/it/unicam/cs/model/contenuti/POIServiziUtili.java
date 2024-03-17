package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.info.Contatti;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;

import java.util.List;

public final class POIServiziUtili extends POI {

    private Contatti contatti;
    private String orariApertura;

    public POIServiziUtili(Integer id, String nome, Posizione posizione, String tipo,
                           Utente contributore, Comune comuneAssociato, Indirizzo indirizzo,
                           List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati,
                           Contatti contatti, String orariApertura) {

        super(id, nome, posizione, tipo, contributore, comuneAssociato, indirizzo, contenutiMultimediali,
                contenutiMultimedialiInPending, eventiAssociati);
        this.contatti = contatti;
        this.orariApertura = orariApertura;
    }

}
