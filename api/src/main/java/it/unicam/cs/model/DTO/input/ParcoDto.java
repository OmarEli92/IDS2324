package it.unicam.cs.model.DTO.input;

import io.swagger.annotations.ApiModel;
import it.unicam.cs.Visitor.POI.IPoiDtoVisitor;
import it.unicam.cs.util.enums.TipoPOI;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ApiModel("dto per parco")
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
