package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.util.Contatti;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.ServiziUtili;

import java.util.List;

public class POIServiziUtili extends POI {

    private Contatti contatti;
    private String orariApertura;

    public POIServiziUtili(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore, Posizione posizione,
                           ServiziUtili tipo, Indirizzo indirizzo, List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati) {
        super(comuneAssociato, id, nome, utenteCreatore, posizione, tipo, indirizzo, contenutiMultimediali, contenutiMultimedialiInPending, eventiAssociati);
    }
}
