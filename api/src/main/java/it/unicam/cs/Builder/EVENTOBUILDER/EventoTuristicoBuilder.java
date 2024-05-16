package it.unicam.cs.Builder.EVENTOBUILDER;

import it.unicam.cs.Visitor.Evento.IEventoBuilderVisitor;
import it.unicam.cs.model.DTO.input.EventoDto;
import it.unicam.cs.model.DTO.input.EventoTuristicoDto;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.EventoTuristico;
import it.unicam.cs.util.enums.TipoEvento;
import it.unicam.cs.util.enums.TipoTuristico;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EventoTuristicoBuilder extends EventoBuilder {
    private TipoTuristico tipo;
    public void setTipo(TipoTuristico tipo) {
        this.tipo = tipo;
    }


    @Override
    public Evento build() {
        return new EventoTuristico(super.getComuneAssociato(),super.getNome(),super.getDescrizione(), super.isAttivo(),TipoEvento.TURISTICO, super.getContributore(), super.getStato(),
                super.getPoiAssociato(),super.getDataInizio(),super.getDataFine(),super.getContenutiMultimediali(),tipo);
    }

    @Override
    public void accept(IEventoBuilderVisitor eventoBuilderVisitor, EventoDto eventoDto) {
        eventoBuilderVisitor.visit(this,(EventoTuristicoDto) eventoDto);
    }
}
