package it.unicam.cs.Builder.EVENTOBUILDER;

import io.swagger.annotations.ApiModel;
import it.unicam.cs.Visitor.Evento.IEventoBuilderVisitor;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.DTO.EventoTuristicoDto;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.EventoTuristico;
import it.unicam.cs.util.enums.TipoTuristico;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
public class EventoTuristicoBuilder extends EventoBuilder {
    private TipoTuristico tipo;
    public void setTipo(TipoTuristico tipo) {
        this.tipo = tipo;
    }


    @Override
    public Evento build() {
        return new EventoTuristico(super.getComuneAssociato(),super.getNome(),super.getDescrizione(), super.getContributore(),
                super.getPoiAssociato(),super.getDataInizio(),super.getDataFine(),super.getContenutiMultimediali(),tipo);
    }

    @Override
    public void accept(IEventoBuilderVisitor eventoBuilderVisitor, EventoDto eventoDto) {
        eventoBuilderVisitor.visit(this,(EventoTuristicoDto) eventoDto);
    }
}
