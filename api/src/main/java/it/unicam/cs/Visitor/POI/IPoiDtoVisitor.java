package it.unicam.cs.Visitor.POI;

import it.unicam.cs.model.DTO.*;
import org.springframework.stereotype.Component;

@Component
public interface IPoiDtoVisitor {
    void visit(PoiAmministrativoDto poi);
    void visit(PoiIntrattenimentoDto poi);
    void visit(ParcoDto poi);
    void visit (MuseoDto museoDto);
    void visit (PoiServiziUtiliDto poiServiziUtiliDto);
    void visit (MonumentoDto monumentoDto);
}
