package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.util.*;
import it.unicam.cs.util.enums.CollezioniMuseo;
import it.unicam.cs.util.enums.StatoContenuto;
import it.unicam.cs.util.enums.TipoTuristico;

import java.time.LocalDateTime;
import java.util.List;

public final class Museo extends POI {
    private LocalDateTime orariApertura;
    private String responsabile;
    private Contatti contatti;
    private int numeroSale;
    private List<CollezioniMuseo> collezioni;
    public Museo(String nome, Posizione posizione,
                 Utente contributore, Comune comuneAssociato, Indirizzo indirizzo, StatoContenuto statoContenuto,
                 LocalDateTime orariApertura, String responsabile, Contatti contatti, int numeroSale, List<CollezioniMuseo> collezioni) {
        super( nome, posizione, contributore, comuneAssociato, indirizzo, statoContenuto);
        this.orariApertura = orariApertura;
        this.responsabile = responsabile;
        this.contatti = contatti;
        this.numeroSale = numeroSale;
        this.collezioni = collezioni;
    }

    public LocalDateTime getOrariApertura() {
        return orariApertura;
    }

    public void setOrariApertura(LocalDateTime orariApertura) {
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
