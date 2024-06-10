package it.unicam.cs.Factory.Evento;

import it.unicam.cs.Builder.EVENTOBUILDER.EventoBuilder;
import it.unicam.cs.model.DTO.input.EventoDto;
import org.springframework.stereotype.Component;

@Component
public interface IEventoBuilderFactory {
    public EventoBuilder creaBuilder(EventoDto eventoDto);
}
