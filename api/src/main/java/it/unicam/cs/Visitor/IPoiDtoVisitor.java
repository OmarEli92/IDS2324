package it.unicam.cs.Visitor;

import it.unicam.cs.model.DTO.*;

public interface IPoiDtoVisitor {
    void visit(PoiAmministrativoDto poi);
    void visit(PoiIntrattenimentoDto poi);
    void visit(ParcoDto poi);
    void visit (MuseoDto museoDto);
    void visit (PoiServiziUtiliDto poiServiziUtiliDto);
    void visit (MonumentoDto monumentoDto);
}