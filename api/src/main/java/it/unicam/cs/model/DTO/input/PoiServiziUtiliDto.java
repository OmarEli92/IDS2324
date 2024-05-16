package it.unicam.cs.model.DTO.input;

import io.swagger.annotations.ApiModel;
import it.unicam.cs.Visitor.POI.IPoiDtoVisitor;
import it.unicam.cs.util.enums.TipoPOI;
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

    @Override
    public String getTipoPoi() {
        return TipoPOI.SERVIZI_UTILI.name();
    }

    @Override
    public void accept(IPoiDtoVisitor poiDtoVisitor) {
        poiDtoVisitor.visit(this);
    }
}
