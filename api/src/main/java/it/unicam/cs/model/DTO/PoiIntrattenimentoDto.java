package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import it.unicam.cs.util.info.Contatti;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
@ApiModel("dto per poi intrattenimento")
public class PoiIntrattenimentoDto extends PoiDto {
    private String tipo;
    private int etaConsigliata;
    private String orariApertura;
    @ApiModelProperty(value = "tipi di servizi offerti", allowableValues = "Servizio")
    private List<Servizio> serviziOfferti;
    private Contatti contatti;
}
