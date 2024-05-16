package it.unicam.cs.Factory.Evento;

import it.unicam.cs.Builder.EVENTOBUILDER.EventoAmministrativoBuilder;
import it.unicam.cs.Builder.EVENTOBUILDER.EventoBuilder;
import it.unicam.cs.Builder.EVENTOBUILDER.EventoIntrattenimentoBuilder;
import it.unicam.cs.Builder.EVENTOBUILDER.EventoTuristicoBuilder;
import it.unicam.cs.model.DTO.input.EventoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DefaultEventoBuilderFactory implements IEventoBuilderFactory {
    @Override
    public EventoBuilder creaBuilder(EventoDto eventoDto) {
        String evento = eventoDto.getTipoEvento().toUpperCase();
        switch (evento){
            case "INTRATTENIMENTO" :
                return new EventoIntrattenimentoBuilder();
            case "AMMINISTRATIVO" :
                return new EventoAmministrativoBuilder();
            case "TURISTICO" :
                return new EventoTuristicoBuilder();
            default:
                throw new IllegalArgumentException("Tipo di EventoBuilder non supportato");
        }
    }
}
