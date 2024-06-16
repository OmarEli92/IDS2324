package it.unicam.cs.Builder.POIBUILDER;

import it.unicam.cs.Visitor.POI.IPOIBuilderVisitor;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.DTO.input.PoiIntrattenimentoDto;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.POIIntrattenimento;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import it.unicam.cs.util.enums.TipoPOI;
import it.unicam.cs.util.info.Contatti;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class POIIntrattenimentoBuilder extends POIBuilder{
    private TipoIntrattenimento tipo;
    private int etaConsigliata;
    private String orariApertura;
    private List<Servizio> serviziOfferti;
    private Contatti contatti;

    public void setTipo(TipoIntrattenimento tipo) {this.tipo = tipo;}
    public void setEtaConsigliata(int etaConsigliata) {
        this.etaConsigliata = etaConsigliata;
    }

    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    public void setServiziOfferti(List<Servizio> serviziOfferti) {
        this.serviziOfferti = serviziOfferti;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }

    @Override
    public POI build() {
        return new POIIntrattenimento(super.getNome(),super.getPosizione(), TipoPOI.INTRATTENIMENTO,
                super.getContributore(),super.getStato(),super.getComuneAssociato(),super.getEventiAssociati(),
                super.getContenutiMultimediali(),tipo, etaConsigliata,orariApertura,serviziOfferti,contatti);
    }

    @Override
    public void accept(IPOIBuilderVisitor ipoiBuilderVisitor, PoiDto poiDto) {
        ipoiBuilderVisitor.visit(this,(PoiIntrattenimentoDto) poiDto);
    }
}
