package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.util.*;

import java.util.List;

public class POIAmministrativo extends POI {
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;
    public POIAmministrativo(int id, String nome, Posizione posizione, TipoAmministrativo tipo,
                             int idContributore, Comune comuneAssociato, Indirizzo indirizzo,
                             List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati, List eventiAssociatiInPending,
                             String orariApertura, String responsabile, Contatti contatti) {


        super(id, nome, posizione, tipo, idContributore, comuneAssociato, indirizzo, contenutiMultimediali,
                contenutiMultimedialiInPending, eventiAssociati, eventiAssociatiInPending);
        this.orariApertura = orariApertura;
        this.responsabile = responsabile;
        this.contatti = contatti;
    }

    public String getOrariApertura() {
        return orariApertura;
    }

    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    public Contatti getContatti() {
        return contatti;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }
}

