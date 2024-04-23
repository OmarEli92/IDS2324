package it.unicam.cs.Builder.POIBUILDER;

import it.unicam.cs.Visitor.POI.IPOIBuilderVisitor;
import it.unicam.cs.model.DTO.PoiAmministrativoDto;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.POIAmministrativo;
import it.unicam.cs.util.enums.TipoAmministrativo;
import it.unicam.cs.util.info.Contatti;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class POIAmministrativoBuilder extends POIBuilder {
    private TipoAmministrativo tipo;
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;

    public void setTipo(TipoAmministrativo tipo) {this.tipo = tipo;}
    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    public void setResponsabile(String responsabile) {
        this.responsabile = responsabile;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }

    @Override
    POI build() {
        return new POIAmministrativo(super.getNome(),super.getPosizione(),
                super.getContributore(),super.getStato(),super.getComuneAssociato(),super.getIndirizzo(),
                super.getEventiAssociati(),super.getContenutiMultimediali(),tipo,orariApertura,responsabile,contatti);
    }

    @Override
    public void accept(IPOIBuilderVisitor ipoiBuilderVisitor, PoiDto poiDto) {
        ipoiBuilderVisitor.visit(this, (PoiAmministrativoDto) poiDto);
    }
}
