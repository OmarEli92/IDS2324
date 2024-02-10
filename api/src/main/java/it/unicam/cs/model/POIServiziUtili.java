package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.util.Contatti;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.enums.ServiziUtili;

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
