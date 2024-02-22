package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;

import java.time.LocalDateTime;
import java.util.List;

public abstract class IParcoBuilder {
    protected String nome;
    protected Indirizzo indirizzo;
    protected Posizione posizione;
    protected Comune comuneAssociato;
    protected boolean presenzaSpecieProtetta;
    protected LocalDateTime orarioApertura;
    protected List<Itinerario> percorsi;
    protected boolean presenzaAnimali;
    protected int estensione;
    public void setPresenzaSpecieProtetta(boolean presenzaSpecieProtetta) {
        this.presenzaSpecieProtetta = presenzaSpecieProtetta;
    }

    public void setOrarioApertura(LocalDateTime orarioApertura) {
        this.orarioApertura = orarioApertura;
    }

    public void setPercorsi(List<Itinerario> percorsi) {
        this.percorsi=percorsi;
    }

    public void setPresenzaAnimali(boolean presenzaAnimali) {
        this.presenzaAnimali = presenzaAnimali;
    }

    public void setEstensione(int estensione) {
        if(estensione<=0)
            throw new IllegalArgumentException("l'estensione deve essere maggiore di 0");
        else
            this.estensione=estensione;
    }
    abstract void setContributore(Utente contributore);
    abstract void setStatoContenuto();
    abstract POI build();
}
