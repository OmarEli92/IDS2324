package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.util.*;
import it.unicam.cs.util.enums.StatoContenuto;
import it.unicam.cs.util.enums.TipoTuristico;

import java.util.List;

public final class Monumento extends POI {

    private int annoRealizzazione;
    private String descrizione;
    private String autore;
    private int altezza;
    private int lunghezza;
    private String architettura;
    public Monumento(String nome, Posizione posizione, Utente contributore, Comune comuneAssociato, Indirizzo indirizzo, StatoContenuto statoContenuto,
                     int annoRealizzazione, String descrizione, String autore, int altezza,
                     int lunghezza, String architettura) {

        super( nome, posizione,contributore, comuneAssociato, indirizzo, statoContenuto);
        this.annoRealizzazione = annoRealizzazione;
        this.descrizione = descrizione;
        this.autore = autore;
        this.altezza = altezza;
        this.lunghezza = lunghezza;
        this.architettura = architettura;


    }

}
