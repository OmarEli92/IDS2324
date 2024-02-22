package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.util.*;
import it.unicam.cs.util.enums.StatoContenuto;
import it.unicam.cs.util.enums.TipoAmministrativo;

import java.time.LocalDateTime;
import java.util.List;

public class POIAmministrativo extends POI {
    private LocalDateTime orariApertura;
    private String responsabile;
    private Contatti contatti;
    public POIAmministrativo(String nome, Posizione posizione,
                             Utente contributore, Comune comuneAssociato, Indirizzo indirizzo, StatoContenuto statoContenuto,
                             LocalDateTime orariApertura, String responsabile, Contatti contatti) {


        super(nome, posizione, contributore, comuneAssociato, indirizzo,statoContenuto);
        this.orariApertura = orariApertura;
        this.responsabile = responsabile;
        this.contatti = contatti;
    }

    public LocalDateTime getOrariApertura() {
        return orariApertura;
    }

    public void setOrariApertura(LocalDateTime orariApertura) {
        this.orariApertura = orariApertura;
    }

    public Contatti getContatti() {
        return contatti;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }
}

