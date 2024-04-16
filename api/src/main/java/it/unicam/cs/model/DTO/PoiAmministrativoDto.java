package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.unicam.cs.util.enums.TipoAmministrativo;
import it.unicam.cs.util.info.Contatti;

@ApiModel("dto per poi amministrativo")
public class PoiAmministrativoDto extends PoiDto {
    @ApiModelProperty(value = "tipo di amministrazione", allowableValues = "TipoAmministrativo")
    private TipoAmministrativo tipo;
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;
}
