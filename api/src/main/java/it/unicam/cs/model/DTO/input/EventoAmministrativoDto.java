package it.unicam.cs.model.DTO.input;

import io.swagger.annotations.ApiModel;
import it.unicam.cs.Visitor.Evento.IEventoDtoVisitor;
import it.unicam.cs.util.enums.TipoEvento;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ApiModel("dto per evento amministrativo")
public class EventoAmministrativoDto extends EventoDto{
    private String tipo;
    private String responsabile;

    @Override
    public String getTipoEvento() {
        return TipoEvento.AMMINISTRATIVO.name();
    }

    @Override
    public void accept(IEventoDtoVisitor eventoDtoVisitor) {
        eventoDtoVisitor.visit(this);
    }
}
