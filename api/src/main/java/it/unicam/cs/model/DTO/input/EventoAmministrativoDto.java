package it.unicam.cs.model.DTO.input;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import it.unicam.cs.Visitor.Evento.IEventoDtoVisitor;
import it.unicam.cs.util.enums.TipoEvento;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@JsonTypeName("amministrativo")
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
