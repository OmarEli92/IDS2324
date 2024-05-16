package it.unicam.cs.Builder.POIBUILDER;

import it.unicam.cs.Visitor.POI.IPOIBuilderVisitor;
import it.unicam.cs.model.DTO.input.MuseoDto;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Museo;
import it.unicam.cs.util.enums.CollezioniMuseo;
import it.unicam.cs.util.enums.TipoPOI;
import it.unicam.cs.util.info.Contatti;

import java.util.List;

public class MuseoBuilder extends POIBuilder {
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;
    private int numeroSale;
    private List<CollezioniMuseo> collezioni;


    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    public void setResponsabile(String responsabile) {
        this.responsabile = responsabile;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }

    public void setNumeroSale(int numeroSale) {
        this.numeroSale = numeroSale;
    }

    public void setCollezioni(List<CollezioniMuseo> collezioni) {
        this.collezioni = collezioni;
    }

    @Override
    public POI build() {
        return new Museo(super.getNome(),super.getPosizione(), TipoPOI.MUSEO, super.getContributore(), super.getStato(),
                super.getComuneAssociato(),super.getIndirizzo(),super.getEventiAssociati(),super.getContenutiMultimediali(),
                orariApertura,responsabile,contatti,numeroSale,collezioni);
    }

    @Override
    public void accept(IPOIBuilderVisitor ipoiBuilderVisitor, PoiDto poiDto) {
        ipoiBuilderVisitor.visit(this,(MuseoDto) poiDto);
    }
}
