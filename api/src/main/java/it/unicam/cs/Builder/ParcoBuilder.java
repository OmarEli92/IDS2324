package it.unicam.cs.Builder;

import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.contenuti.Parco;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ParcoBuilder extends POIBuilder{
    private boolean presenzaSpecieProtetta;
    private String orarioApertura;
    private List<Itinerario> percorsi;
    private boolean presenzaAnimali;
    private int estensione;


    public void setPresenzaSpecieProtetta(boolean presenzaSpecieProtetta) {
        this.presenzaSpecieProtetta = presenzaSpecieProtetta;
    }

    public void setOrarioApertura(String orarioApertura) {
        this.orarioApertura = orarioApertura;
    }

    public void setPercorsi(List<Itinerario> percorsi) {
        this.percorsi = percorsi;
    }

    public void setPresenzaAnimali(boolean presenzaAnimali) {
        this.presenzaAnimali = presenzaAnimali;
    }

    public void setEstensione(int estensione) {
        this.estensione = estensione;
    }

    @Override
    POI build() {
        return new Parco(super.getId(),super.getNome(),super.getPosizione(),super.getContributore(),
                super.getComuneAssociato(),super.getIndirizzo(),super.getEventiAssociati(),super.getContenutiMultimediali(),
                presenzaSpecieProtetta,orarioApertura,percorsi,presenzaAnimali,estensione);
    }
}
