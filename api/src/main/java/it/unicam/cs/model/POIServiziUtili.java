package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.util.Contatti;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.ServiziUtili;

import java.util.List;

public final class POIServiziUtili extends POI {

    private Contatti contatti;
    private String orariApertura;

    public POIServiziUtili(int id, String nome, Posizione posizione, ServiziUtili tipo,
                           int idContributore, int idComuneAssociato, Indirizzo indirizzo,
                           List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati,
                           Contatti contatti, String orariApertura) {

        super(id, nome, posizione, tipo, idContributore, idComuneAssociato, indirizzo, contenutiMultimediali,
                contenutiMultimedialiInPending, eventiAssociati);
        this.contatti = contatti;
        this.orariApertura = orariApertura;
    }

}
