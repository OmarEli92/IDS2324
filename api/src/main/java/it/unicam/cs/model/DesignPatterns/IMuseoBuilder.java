package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.POI;
import it.unicam.cs.util.Contatti;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.enums.CollezioniMuseo;

import java.time.LocalDateTime;
import java.util.List;

public abstract class IMuseoBuilder {
    protected String nome;
    protected Indirizzo indirizzo;
    protected Posizione posizione;
    protected Comune comuneAssociato;
    protected LocalDateTime orariApertura;
    protected String responsabile;
    protected Contatti contatti;
    protected int numeroSale;
    protected List<CollezioniMuseo> collezioni;
    public void setOrariApertura(LocalDateTime orariApertura) {
        this.orariApertura = orariApertura;
    }

    public void setResponsabile(String responsabile) {
        if(responsabile==null)
            throw new IllegalArgumentException("il responsabile non può essere null");
        this.responsabile=responsabile;
    }

    public void setContatti(Contatti contatti) {
        if(contatti==null)
            throw new IllegalArgumentException("i contatti non possono essere null");
        this.contatti=contatti;
    }

    public void setNumeroSale(int numeroSale) {
        if(numeroSale<=0)
            throw new IllegalArgumentException("il numero delle sale deve essere > 0");
    }

    public void setCollezioni(List<CollezioniMuseo> collezioni) {
        if( collezioni==null)
            throw new IllegalArgumentException("le collezioni non possono essere null");
    }

    abstract void setStatoContenuto();
    abstract void setContributore(Utente contributore);
    abstract POI build();
}
