package it.unicam.cs.Visitor.Evento;

import it.unicam.cs.Visitor.POI.IPoiDtoVisitor;

public interface IEventoDtoVisitable {
    public void accept(IEventoDtoVisitor eventoDtoVisitor);
}
