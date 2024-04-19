package it.unicam.cs.model.DTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
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
}
