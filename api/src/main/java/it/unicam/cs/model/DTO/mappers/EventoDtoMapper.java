package it.unicam.cs.model.DTO.mappers;

import it.unicam.cs.model.DTO.output.EventoOutputDto;
import it.unicam.cs.model.abstractions.Evento;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EventoDtoMapper implements Function<Evento, EventoOutputDto> {
    @Override
    public EventoOutputDto apply(Evento evento) {
        return new EventoOutputDto(
                evento.getId(),
                evento.getNome(),
                evento.getDescrizione(),
                evento.getPoiAssociato().getNome(),
                evento.getComuneAssociato().getNome(),
                evento.getContributore().getId(),
                evento.getDataInizio(),
                evento.getDataFine()
        );
    }
}
