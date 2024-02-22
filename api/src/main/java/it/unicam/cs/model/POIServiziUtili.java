package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.util.Contatti;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.enums.ServiziUtili;
import it.unicam.cs.util.enums.StatoContenuto;

import java.time.LocalDateTime;
import java.util.List;

public final class POIServiziUtili extends POI {

    private Contatti contatti;
    private LocalDateTime orariApertura;

    public POIServiziUtili(String nome, Posizione posizione, Utente contributore, Comune comuneAssociato, Indirizzo indirizzo, StatoContenuto statoContenuto,
                           Contatti contatti, LocalDateTime orariApertura) {

        super(nome, posizione, contributore, comuneAssociato, indirizzo, statoContenuto);
        this.contatti = contatti;
        this.orariApertura = orariApertura;
    }

}
