package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.util.*;

import java.util.List;

public final class Monumento extends POI {

    private int annoRealizzazione;
    private String descrizione;
    private String autore;
    private int altezza;
    private int lunghezza;
    private String architettura;
    public Monumento(int id, String nome, Posizione posizione, TipoTuristico tipo,
                     int idContributore, int idComuneAssociato, Indirizzo indirizzo,
                     List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati,
                     int annoRealizzazione, String descrizione, String autore, int altezza,
                     int lunghezza, String architettura) {

        super(id, nome, posizione, tipo, idContributore, idComuneAssociato, indirizzo, contenutiMultimediali,
                contenutiMultimedialiInPending, eventiAssociati);
        this.annoRealizzazione = annoRealizzazione;
        this.descrizione = descrizione;
        this.autore = autore;
        this.altezza = altezza;
        this.lunghezza = lunghezza;
        this.architettura = architettura;


    }

}
