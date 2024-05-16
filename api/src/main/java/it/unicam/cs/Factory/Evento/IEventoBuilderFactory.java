package it.unicam.cs.Factory.Evento;

import it.unicam.cs.Builder.EVENTOBUILDER.EventoBuilder;
import it.unicam.cs.model.DTO.input.EventoDto;

public interface IEventoBuilderFactory {
    public EventoBuilder creaBuilder(EventoDto eventoDto);
}
