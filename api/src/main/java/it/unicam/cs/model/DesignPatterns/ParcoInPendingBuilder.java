package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.model.Parco;
import it.unicam.cs.util.enums.Ruolo;
import it.unicam.cs.util.enums.StatoContenuto;

import java.time.LocalDateTime;
import java.util.List;

public class ParcoInPendingBuilder extends IParcoBuilder{
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
        return new Parco(nome,posizione,contributore,comuneAssociato,indirizzo,statoContenuto,presenzaSpecieProtetta,orarioApertura,percorsi,presenzaAnimali,estensione);
    }
}
