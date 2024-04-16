package it.unicam.cs.model.DTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import it.unicam.cs.model.contenuti.Itinerario;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
@ApiModel("dto per parco")
public class ParcoDto extends PoiDto{
    private boolean presenzaSpecieProtetta;
    private String orarioApertura;
    private boolean presenzaAnimali;
    private int estensione;
}
