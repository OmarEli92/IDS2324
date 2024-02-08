package it.unicam.cs.model;

import it.unicam.cs.util.*;

import java.util.List;

public class POIAmministrativo extends POI {
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;
    public POIAmministrativo(String id, String nome, Posizione posizione, TipoAmministrativo tipo,
                             String idContributore, String idComuneAssociato, Indirizzo indirizzo,
                             List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati,
                             String orariApertura, String responsabile, Contatti contatti) {


        super(id, nome, posizione, tipo, idContributore, idComuneAssociato, indirizzo, contenutiMultimediali,
                contenutiMultimedialiInPending, eventiAssociati);
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

