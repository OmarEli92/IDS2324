package it.unicam.cs.model.DTO.input;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import it.unicam.cs.Visitor.POI.IPoiDtoVisitor;
import it.unicam.cs.util.enums.TipoPOI;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@JsonTypeName("parco")
public class ParcoDto extends PoiDto{
    private boolean presenzaSpecieProtetta;
    private String orarioApertura;
    private boolean presenzaAnimali;
    private int estensione;

    @Override
    public String getTipoPoi() {
        return TipoPOI.PARCO.name();
    }

    @Override
    public void accept(IPoiDtoVisitor poiDtoVisitor) {
        poiDtoVisitor.visit(this);
    }
}
