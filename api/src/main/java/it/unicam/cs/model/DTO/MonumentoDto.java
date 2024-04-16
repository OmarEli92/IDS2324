package it.unicam.cs.model.DTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

@ApiModel("dto per monumento")
public class MonumentoDto extends PoiDto{
    private int annoRealizzazione;
    private String descrizione;
    private String autore;
    private int altezza;
    private int lunghezza;
    private String architettura;
}
