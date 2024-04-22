package it.unicam.cs.Builder.POIBUILDER;

import it.unicam.cs.Visitor.POI.IPOIBuilderVisitor;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.DTO.PoiServiziUtiliDto;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.POIServiziUtili;
import it.unicam.cs.util.enums.ServiziUtili;
import it.unicam.cs.util.info.Contatti;
import org.springframework.stereotype.Component;

@Component
public class POIServiziUtiliBuilder extends POIBuilder{
    private ServiziUtili servizio;
    private Contatti contatti;
    private String orariApertura;

    public void setServizio(ServiziUtili servizio) {this.servizio = servizio;}
    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }

    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    @Override
    POI build() {
        return new POIServiziUtili(super.getId(),super.getNome(),super.getPosizione(),super.getContributore(), super.getStato(),
                super.getComuneAssociato(),super.getIndirizzo(),super.getEventiAssociati(),super.getContenutiMultimediali(),servizio,contatti,orariApertura);
    }

    @Override
    public void accept(IPOIBuilderVisitor ipoiBuilderVisitor, PoiDto poiDto) {
        ipoiBuilderVisitor.visit(this,(PoiServiziUtiliDto) poiDto);
    }
}
