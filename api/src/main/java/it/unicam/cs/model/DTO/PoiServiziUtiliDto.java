package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.unicam.cs.util.enums.ServiziUtili;
import it.unicam.cs.util.info.Contatti;
import jakarta.persistence.Embedded;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ApiModel("dto per poi servizi utili")
public class PoiServiziUtiliDto extends PoiDto{
    private String servizio;
    @Embedded
    private Contatti contatti;
    private String orariApertura;
}
