package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.unicam.cs.util.enums.TipoAmministrativo;
import it.unicam.cs.util.info.Contatti;
import jakarta.persistence.Embedded;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ApiModel("dto per poi amministrativo")
public class PoiAmministrativoDto extends PoiDto {
    private String tipo;
    private String orariApertura;
    private String responsabile;
    @Embedded
    private Contatti contatti;
}
