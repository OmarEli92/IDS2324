package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.util.enums.TipoTuristico;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ApiModel("dto per evento turistico")
public class EventoTuristicoDto extends EventoDto{
    @ApiModelProperty(value = "tipo turistico", allowableValues = "TipoTuristico")
    private TipoTuristico tipo;
    private List<ContenutoMultimediale> contenutiMultimediali;
}
