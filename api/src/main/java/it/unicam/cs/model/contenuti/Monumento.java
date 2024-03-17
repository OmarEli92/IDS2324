package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;

import java.util.List;

public final class Monumento extends POI {

    private int annoRealizzazione;
    private String descrizione;
    private String autore;
    private int altezza;
    private int lunghezza;
    private String architettura;
    public Monumento(Integer id, String nome, Posizione posizione, String tipo,
                     Utente contributore, Comune comuneAssociato, Indirizzo indirizzo,
                     List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati,
                     int annoRealizzazione, String descrizione, String autore, int altezza,
                     int lunghezza, String architettura) {

        super(id, nome, posizione, tipo, contributore, comuneAssociato, indirizzo, contenutiMultimediali,
                contenutiMultimedialiInPending, eventiAssociati);
        this.annoRealizzazione = annoRealizzazione;
        this.descrizione = descrizione;
        this.autore = autore;
        this.altezza = altezza;
        this.lunghezza = lunghezza;
        this.architettura = architettura;


    }

}
