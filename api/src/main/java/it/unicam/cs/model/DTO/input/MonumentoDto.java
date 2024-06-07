package it.unicam.cs.model.DTO.input;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import it.unicam.cs.Visitor.POI.IPoiDtoVisitor;
import it.unicam.cs.util.enums.TipoPOI;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@JsonTypeName("Monumento")
public class MonumentoDto extends PoiDto{
    private int annoRealizzazione;
    private String descrizione;
    private String autore;
    private double altezza;
    private double lunghezza;
    private String architettura;

    @Override
    public String getTipoPoi() {
        return TipoPOI.MONUMENTO.name();
    }

    @Override
    public void accept(IPoiDtoVisitor poiDtoVisitor) {
        poiDtoVisitor.visit(this);
    }
}
