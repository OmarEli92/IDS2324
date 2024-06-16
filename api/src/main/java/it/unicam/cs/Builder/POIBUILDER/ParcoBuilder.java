package it.unicam.cs.Builder.POIBUILDER;

import it.unicam.cs.Visitor.POI.IPOIBuilderVisitor;
import it.unicam.cs.model.DTO.input.ParcoDto;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.contenuti.Parco;
import it.unicam.cs.util.enums.TipoPOI;
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
    public POI build() {
        return new Parco(super.getNome(),super.getPosizione(), TipoPOI.PARCO,super.getContributore(), super.getStato(),
                super.getComuneAssociato(),super.getEventiAssociati(),super.getContenutiMultimediali(),
                presenzaSpecieProtetta,orarioApertura,percorsi,presenzaAnimali,estensione);
    }

    @Override
    public void accept(IPOIBuilderVisitor ipoiBuilderVisitor, PoiDto poiDto) {
        ipoiBuilderVisitor.visit(this,(ParcoDto) poiDto);
    }
}
