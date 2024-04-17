package it.unicam.cs.Factory;

import it.unicam.cs.Builder.EVENTOBUILDER.EventoBuilder;
import it.unicam.cs.Builder.EVENTOBUILDER.EventoIntrattenimentoBuilder;
import it.unicam.cs.Builder.EVENTOBUILDER.EventoTuristicoBuilder;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.DTO.EventoIntrattenimentoDto;
import it.unicam.cs.model.DTO.EventoTuristicoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventoBuilderFactory {
    private final EventoIntrattenimentoBuilder eventoIntrattenimentoBuilder;
    private final EventoTuristicoBuilder eventoTuristicoBuilder;

    public EventoBuilder createBuilder(EventoDto eventoDto){
        if(eventoDto instanceof EventoTuristicoDto){
            return eventoTuristicoBuilder;
        }
        else if(eventoDto instanceof EventoIntrattenimentoDto){
            return eventoIntrattenimentoBuilder;
        }
        else throw new IllegalArgumentException("tipo di evento non esistente");
    }
}
