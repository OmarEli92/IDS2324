package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.POI;
import it.unicam.cs.model.POIAmministrativo;
import it.unicam.cs.util.Contatti;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.enums.Ruolo;
import it.unicam.cs.util.enums.StatoContenuto;

import java.time.LocalDateTime;

public class POIAmministrativoInPendingBuilder extends  IPOIAmministrativoBuilder{
    private Utente contributore;
    private StatoContenuto statoContenuto;


    @Override
    public void setContributore(Utente contributore) {
        if(contributore.getRuolo()==Ruolo.CONTRIBUTOR)
            this.contributore=contributore;
        else
            throw new IllegalArgumentException("l'utente deve essere un contributor");
    }

    @Override
    public void setStatoContenuto() {
        this.statoContenuto=StatoContenuto.PENDING;
    }


    @Override
    public POI build(){
        return new POIAmministrativo(nome,posizione,contributore,comuneAssociato,indirizzo,statoContenuto,orariApertura,responsabile,contatti) ;
    }
}
