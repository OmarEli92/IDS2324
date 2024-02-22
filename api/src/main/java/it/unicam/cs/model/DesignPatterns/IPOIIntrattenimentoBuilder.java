package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.POI;
import it.unicam.cs.util.Contatti;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.enums.Servizio;

import java.time.LocalDateTime;
import java.util.List;

public abstract class IPOIIntrattenimentoBuilder {
    protected String nome;
    protected Indirizzo indirizzo;
    protected Posizione posizione;
    protected Comune comuneAssociato;
    protected int etaConsigliata;
    protected LocalDateTime orariApertura;
    protected List<Servizio> serviziOfferti;
    protected Contatti contatti;
    public void setOrariApertura(LocalDateTime orariApertura) {
        this.orariApertura = orariApertura;
    }

    public void setServiziOfferti(List<Servizio> serviziOfferti) {
        if(serviziOfferti!=null)
            this.serviziOfferti=serviziOfferti;
        else
            throw new IllegalArgumentException("i servizi offerti non possono essere null");
    }
    public void setEtaConsigliata(int etaConsigliata) {
        if(!(etaConsigliata<=0))
            this.etaConsigliata=etaConsigliata;
        else
            throw new IllegalArgumentException("l'età deve essere >0");
    }

    public void setContatti(Contatti contatti) {
        if(contatti!=null)
            this.contatti = contatti;
        else
            throw new IllegalArgumentException("i contatti non possono essere null");
    }
    abstract void setStatoContenuto();
    abstract void setContributore(Utente contributore);
    abstract POI build();

}
