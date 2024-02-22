package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.POI;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;

public abstract class IMonumentoBuilder {
    protected String nome;
    protected Indirizzo indirizzo;
    protected Posizione posizione;
    protected Comune comuneAssociato;
    protected int annoRealizzazione;
    protected String descrizione;
    protected String autore;
    protected int altezza;
    protected int lunghezza;
    protected String architettura;
    public void setAnnoRealizzazione(int annoRealizzazione) {
        this.annoRealizzazione = annoRealizzazione;
    }

    public void setDescrizione(String descrizione) {
        if(descrizione==null)
            throw new IllegalArgumentException("la descrizione non può essere null");
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setAltezza(int altezza) {
        if(altezza<=0)
            throw new IllegalArgumentException("l'altezza deve essere > 0");
        else
            this.altezza=altezza;
    }

    public void setLunghezza(int lunghezza) {
        if(lunghezza<=0)
            throw new IllegalArgumentException("la lunghezza deve essere > 0");
    }

    public void setArchitettura(String architettura) {
        this.architettura = architettura;
    }

    abstract void setStatoContenuto();
    abstract void setContributore(Utente contributore);
    abstract POI build();
}
