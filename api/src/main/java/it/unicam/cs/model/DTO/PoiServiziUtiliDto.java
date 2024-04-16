package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.unicam.cs.util.enums.ServiziUtili;
import it.unicam.cs.util.info.Contatti;
@ApiModel("dto per poi servizi utili")
public class PoiServiziUtiliDto extends PoiDto{
    @ApiModelProperty(value = "tipo di servizio", allowableValues = "ServiziUtili")
    private ServiziUtili servizio;
    private Contatti contatti;
    private String orariApertura;
}
