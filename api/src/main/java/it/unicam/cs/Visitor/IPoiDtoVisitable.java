package it.unicam.cs.Visitor;

import it.unicam.cs.model.DTO.PoiDto;

public interface IPoiDtoVisitable {
    public void accept(IPoiDtoVisitor iPoiDtoVisitor);
}
