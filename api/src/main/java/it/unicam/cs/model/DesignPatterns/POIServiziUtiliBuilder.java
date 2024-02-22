package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.POI;
import it.unicam.cs.model.POIServiziUtili;
import it.unicam.cs.util.Contatti;
import it.unicam.cs.util.enums.Ruolo;
import it.unicam.cs.util.enums.StatoContenuto;

import java.time.LocalDateTime;

public class POIServiziUtiliBuilder extends IPOIServiziUtiliBuilder {
    private Utente contributore;
    private StatoContenuto statoContenuto;;

    @Override
    void setContributore(Utente utente) {
        if(contributore.getRuolo()== Ruolo.CONTRIBUTOR_AUTORIZZATO || contributore.getRuolo()==Ruolo.ANIMATORE || contributore.getRuolo()==Ruolo.GESTORE_PIATTAFORMA
                || contributore.getRuolo()==Ruolo.CURATORE)
            this.contributore=contributore;
        else
            throw new IllegalArgumentException("l'utente deve essere o un contributor autorizzato, o un animatore, o il gestore della piattaforma o un curatore");
    }

    @Override
    void setStatoContenuto() {
        this.statoContenuto=StatoContenuto.CARICATO;
    }

    public void setContatti(Contatti contatti) {
        if(contatti==null)
            throw new IllegalArgumentException("i contatti non possono essere null");
        this.contatti=contatti;
    }

    public void setOrariApertura(LocalDateTime orariApertura) {
        this.orariApertura = orariApertura;
    }

    @Override
    POI build() {
        return new POIServiziUtili(nome,posizione,contributore,comuneAssociato,indirizzo,statoContenuto,contatti,orariApertura);
    }
}
