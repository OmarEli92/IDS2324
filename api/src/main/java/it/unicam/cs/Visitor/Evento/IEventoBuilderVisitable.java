package it.unicam.cs.Visitor.Evento;

import it.unicam.cs.Visitor.POI.IPOIBuilderVisitor;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.DTO.PoiDto;

public interface IEventoBuilderVisitable {
    public void accept(IEventoBuilderVisitor eventoBuilderVisitor, EventoDto eventoDto);
}
