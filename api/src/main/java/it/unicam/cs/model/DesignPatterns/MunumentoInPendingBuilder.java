package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Monumento;
import it.unicam.cs.model.POI;
import it.unicam.cs.util.enums.Ruolo;
import it.unicam.cs.util.enums.StatoContenuto;

public class MunumentoInPendingBuilder extends IMonumentoBuilder{
    private Utente contributore;
    private StatoContenuto statoContenuto;


    @Override
    void setContributore(Utente utente) {
        if(contributore.getRuolo()== Ruolo.CONTRIBUTOR)
            this.contributore=contributore;
        else
            throw new IllegalArgumentException("l'utente deve essere un contributor");
    }

    @Override
    void setStatoContenuto() {
        this.statoContenuto=StatoContenuto.PENDING;
    }

    @Override
    POI build() {
        return new Monumento(nome,posizione,contributore,comuneAssociato,indirizzo,statoContenuto,annoRealizzazione,descrizione,autore,altezza,lunghezza,architettura);
    }
}

