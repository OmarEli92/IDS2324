package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.util.*;

import java.util.List;

public class Museo extends POI {
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;
    private int numeroSale;
    private List<CollezioniMuseo> collezioni;
    public Museo(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore, Posizione posizione,
                 TipoTuristico tipo, Indirizzo indirizzo, List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati,
                 String orariApertura, String responsabile, Contatti contatti, int numeroSale, List<CollezioniMuseo> collezioni) {
        super(comuneAssociato, id, nome, utenteCreatore, posizione, tipo,indirizzo, contenutiMultimediali, contenutiMultimedialiInPending, eventiAssociati);
        this.orariApertura = orariApertura;
        this.responsabile = responsabile;
        this.contatti = contatti;
        this.numeroSale = numeroSale;
        this.collezioni = collezioni;
    }

    public String getOrariApertura() {
        return orariApertura;
    }

    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    public String getResponsabile() {
        return responsabile;
    }

    public void setResponsabile(String responsabile) {
        this.responsabile = responsabile;
    }

    public Contatti getContatti() {
        return contatti;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }

    public int getNumeroSale() {
        return numeroSale;
    }

    public void setNumeroSale(int numeroSale) {
        this.numeroSale = numeroSale;
    }

    public List<CollezioniMuseo> getCollezioni() {
        return collezioni;
    }

    public void setCollezioni(List<CollezioniMuseo> collezioni) {
        this.collezioni = collezioni;
    }
}
