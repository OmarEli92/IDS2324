package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Evento;
import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.CollezioniMuseo;

import java.util.List;

public class Monumento extends POI {

    private int annoRealizzazione;
    private String descrizione;
    private String autore;
    private int altezza;
    private int lunghezza;
    private String architettura;
    public Monumento(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore,
                     Posizione posizione, CollezioniMuseo tipo, Indirizzo indirizzo, List<ContenutoMultimediale> contenutiMultimediali,
                     List<ContenutoMultimediale> contenutiMultimedialiInPending, List<Evento> eventi,
                     int annoRealizzazione, String descrizione, String autore, int altezza,
                     int lunghezza, String architettura) {
        super(comuneAssociato, id, nome, utenteCreatore, posizione, tipo, indirizzo, contenutiMultimediali, contenutiMultimedialiInPending, eventi);
        this.annoRealizzazione = annoRealizzazione;
        this.descrizione = descrizione;
        this.autore = autore;
        this.altezza = altezza;
        this.lunghezza = lunghezza;
        this.architettura = architettura;

    }

}
