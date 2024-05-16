package it.unicam.cs.model.DTO.input;

import io.swagger.annotations.ApiModel;
import it.unicam.cs.Visitor.Evento.IEventoDtoVisitor;
import it.unicam.cs.util.enums.TipoEvento;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ApiModel("dto per evento turistico")
public class EventoTuristicoDto extends EventoDto{
    private String tipo;

    @Override
    public String getTipoEvento() {
        return TipoEvento.TURISTICO.name();
    }

    @Override
    public void accept(IEventoDtoVisitor eventoDtoVisitor) {
        eventoDtoVisitor.visit(this);
    }
}
