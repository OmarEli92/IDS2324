package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import it.unicam.cs.Visitor.IPoiDtoVisitor;
import it.unicam.cs.util.enums.TipoPOI;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ApiModel("dto per monumento")
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
