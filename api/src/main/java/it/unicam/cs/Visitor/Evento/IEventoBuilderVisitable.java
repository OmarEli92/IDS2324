package it.unicam.cs.Visitor.Evento;

import it.unicam.cs.model.DTO.input.EventoDto;

public interface IEventoBuilderVisitable {
    public void accept(IEventoBuilderVisitor eventoBuilderVisitor, EventoDto eventoDto);
}
