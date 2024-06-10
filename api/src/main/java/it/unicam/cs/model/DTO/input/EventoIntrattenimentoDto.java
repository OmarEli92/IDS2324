package it.unicam.cs.model.DTO.input;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import it.unicam.cs.Visitor.Evento.IEventoDtoVisitor;
import it.unicam.cs.util.enums.TipoEvento;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@JsonTypeName("intrattenimento")
public class EventoIntrattenimentoDto extends EventoDto{
    private String tipo;
    private int etaConsigliata;
    private List<String> serviziOfferti;

    @Override
    public String getTipoEvento() {
        return TipoEvento.INTRATTENIMENTO.name();
    }

    @Override
    public void accept(IEventoDtoVisitor eventoDtoVisitor) {
        eventoDtoVisitor.visit(this);
    }
}
