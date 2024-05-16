package it.unicam.cs.model.DTO.input;

import io.swagger.annotations.ApiModel;
import it.unicam.cs.Visitor.POI.IPoiDtoVisitor;
import it.unicam.cs.util.enums.TipoPOI;
import it.unicam.cs.util.info.Contatti;
import jakarta.persistence.Embedded;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@ApiModel(description = "dto per un museo")
@Component
@Data
public class MuseoDto extends PoiDto {
    private String orariApertura;
    private String responsabile;
    @Embedded
    private Contatti contatti;
    private int numeroSale;
    private List<String> collezioni;

    @Override
    public String getTipoPoi() {
        return TipoPOI.MUSEO.name();
    }

    @Override
    public void accept(IPoiDtoVisitor poiDtoVisitor) {
        poiDtoVisitor.visit(this);
    }
}
