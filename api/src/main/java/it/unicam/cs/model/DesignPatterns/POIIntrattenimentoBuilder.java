package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.POI;
import it.unicam.cs.model.POIIntrattenimento;
import it.unicam.cs.util.Contatti;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.enums.Ruolo;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.enums.StatoContenuto;

import java.time.LocalDateTime;
import java.util.List;

public class POIIntrattenimentoBuilder extends IPOIIntrattenimentoBuilder{
    private Utente contributore;
    private StatoContenuto statoContenuto;


    @Override
    public void setContributore(Utente utente) {
        if(contributore.getRuolo()== Ruolo.CONTRIBUTOR_AUTORIZZATO || contributore.getRuolo()==Ruolo.ANIMATORE || contributore.getRuolo()==Ruolo.GESTORE_PIATTAFORMA
                || contributore.getRuolo()==Ruolo.CURATORE)
            this.contributore=contributore;
        else
            throw new IllegalArgumentException("l'utente deve essere o un contributor autorizzato, o un animatore, o il gestore della piattaforma o un curatore");
    }



    @Override
    public void setStatoContenuto() {
        this.statoContenuto=StatoContenuto.CARICATO;
    }



    @Override
    public POI build() {
        return new POIIntrattenimento(nome,posizione,contributore,comuneAssociato,indirizzo,statoContenuto,etaConsigliata,orariApertura,serviziOfferti,contatti);
    }
}
