package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.POI;
import it.unicam.cs.util.Contatti;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.enums.StatoContenuto;

import java.time.LocalDateTime;

public abstract class IPOIAmministrativoBuilder {
    protected String nome;
    protected Indirizzo indirizzo;
    protected Posizione posizione;
    protected Comune comuneAssociato;
    protected LocalDateTime orariApertura;
    protected String responsabile;
    protected Contatti contatti;

    public void setNome(String nome){
        if(nome==null)
            throw new IllegalArgumentException("il nome non può essere null");
        this.nome=nome;
    }
    abstract void setContributore(Utente utente);

    public void setPosizione(Posizione posizione){
        if(posizione!=null)
            this.posizione=posizione;
    }

    public void setComuneAssociato(Comune comuneAssociato){
        this.comuneAssociato=comuneAssociato;
    }

    abstract void setStatoContenuto();

    public void setIndirizzo(Indirizzo indirizzo){
        if(indirizzo!=null)
            this.indirizzo=indirizzo;
        else
            throw new IllegalArgumentException("l'indirizzo non può essere null");
    }
    public void setOrariApertura (LocalDateTime orariApertura){
        this.orariApertura=orariApertura;
    }

    public void setResponsabile(String responsabile){
        if(responsabile==null)
            throw new IllegalArgumentException("il responsabile npn può essere null");
        else
            this.responsabile=responsabile;
    }

    public void setContatti (Contatti contatti){
        if(contatti==null )
            throw new IllegalArgumentException("il contatto non può essere null");
        else
            this.contatti=contatti;
    }

    abstract POI build();
}
