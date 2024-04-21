package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import it.unicam.cs.Visitor.IPoiDtoVisitable;
import it.unicam.cs.Visitor.IPoiDtoVisitor;
import it.unicam.cs.util.enums.TipoPOI;
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

    @Override
    public String getTipoPoi() {
        return TipoPOI.AMMINISTRATIVO.name();
    }

    @Override
    public void accept(IPoiDtoVisitor poiDtoVisitor) {
        poiDtoVisitor.visit(this);
    }
}
