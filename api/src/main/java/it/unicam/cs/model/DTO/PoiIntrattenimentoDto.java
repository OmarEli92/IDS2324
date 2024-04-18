package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import it.unicam.cs.util.info.Contatti;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
@ApiModel("dto per poi intrattenimento")
public class PoiIntrattenimentoDto extends PoiDto {
    @ApiModelProperty(value = "tipo di intrattenimento", allowableValues = "TipoIntrattenimento")
    private TipoIntrattenimento tipo;
    private int etaConsigliata;
    private String orariApertura;
    @ApiModelProperty(value = "tipi di servizi offerti", allowableValues = "Servizio")
    private List<Servizio> serviziOfferti;
    @Embedded
    private Contatti contatti;
}
