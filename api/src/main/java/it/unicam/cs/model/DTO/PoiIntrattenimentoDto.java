package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import it.unicam.cs.Visitor.POI.IPoiDtoVisitor;
import it.unicam.cs.util.enums.TipoPOI;
import it.unicam.cs.util.info.Contatti;
import jakarta.persistence.Embedded;
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
    private List<String> serviziOfferti;
    @Embedded
    private Contatti contatti;

    @Override
    public String getTipoPoi() {
        return TipoPOI.INTRATTENIMENTO.name();
    }

    @Override
    public void accept(IPoiDtoVisitor poiDtoVisitor) {
        poiDtoVisitor.visit(this);
    }
}
