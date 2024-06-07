package it.unicam.cs.model.DTO.input;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import it.unicam.cs.Visitor.POI.IPoiDtoVisitor;
import it.unicam.cs.util.enums.TipoPOI;
import it.unicam.cs.util.info.Contatti;
import jakarta.persistence.Embedded;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@JsonTypeName("amministrativo")
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
