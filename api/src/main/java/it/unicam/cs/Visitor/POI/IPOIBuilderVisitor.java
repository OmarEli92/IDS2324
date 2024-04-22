package it.unicam.cs.Visitor.POI;

import it.unicam.cs.Builder.POIBUILDER.*;
import it.unicam.cs.model.DTO.*;
import org.springframework.stereotype.Component;

@Component
public interface IPOIBuilderVisitor {
    void visit(POIAmministrativoBuilder poiAmministrativoBuilder,PoiAmministrativoDto poi);
    void visit(POIIntrattenimentoBuilder poiIntrattenimentoBuilder,PoiIntrattenimentoDto poi);
    void visit(ParcoBuilder parcoBuilder,ParcoDto poi);
    void visit (MuseoBuilder museoBuilder,MuseoDto museoDto);
    void visit (POIServiziUtiliBuilder poiServiziUtiliBuilder,PoiServiziUtiliDto poiServiziUtiliDto);
    void visit (MonumentoBuilder monumentoBuilder,MonumentoDto monumentoDto);
}
