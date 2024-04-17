package it.unicam.cs.model.DTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.util.enums.TipoAmministrativo;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ApiModel("dto per evento amministrativo")
public class EventoAmministrativoDto extends EventoDto{
    @ApiModelProperty(value = "tipo di amministrazione", allowableValues = "TipoAmministrativo")
    private TipoAmministrativo tipo;
    private List<ContenutoMultimediale> contenutiMultimediale;
}
