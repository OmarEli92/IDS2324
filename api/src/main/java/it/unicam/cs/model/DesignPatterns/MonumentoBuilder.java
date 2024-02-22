package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Monumento;
import it.unicam.cs.model.POI;
import it.unicam.cs.util.enums.Ruolo;
import it.unicam.cs.util.enums.StatoContenuto;

public class MonumentoBuilder extends IMonumentoBuilder{
    private Utente contributore;
    private StatoContenuto statoContenuto;


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

    @Override
    POI build() {
        return new Monumento(nome,posizione,contributore,comuneAssociato,indirizzo,statoContenuto,annoRealizzazione,descrizione,autore,altezza,lunghezza,architettura);
    }
}
