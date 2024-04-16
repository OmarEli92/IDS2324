package it.unicam.cs.model.DTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import it.unicam.cs.model.contenuti.Itinerario;

import java.util.List;

@ApiModel("dto per parco")
public class ParcoDto extends PoiDto{
    private boolean presenzaSpecieProtetta;
    private String orarioApertura;
    private boolean presenzaAnimali;
    private int estensione;
}
