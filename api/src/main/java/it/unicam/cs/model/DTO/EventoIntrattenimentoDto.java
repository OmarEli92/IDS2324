package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.util.enums.TipoAmministrativo;
import it.unicam.cs.util.enums.TipoEvento;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ApiModel("dto per evento intrattenimento")
public class EventoIntrattenimentoDto extends EventoDto{
    private String tipo;
    private int etaConsigliata;
    private List<String> serviziOfferti;

    @Override
    public String getTipoEvento() {
        return TipoEvento.INTRATTENIMENTO.name();
    }
}
