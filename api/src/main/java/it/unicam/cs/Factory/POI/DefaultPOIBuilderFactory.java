package it.unicam.cs.Factory.POI;

import it.unicam.cs.Builder.POIBUILDER.*;
import it.unicam.cs.model.DTO.PoiDto;

import static it.unicam.cs.util.enums.TipoPOI.*;

public class DefaultPOIBuilderFactory implements IPOIBuilderFactory{


    @Override
    public POIBuilder creaBuilder(PoiDto poiDto) {
        String poi = poiDto.getTipoPoi().toUpperCase();
        switch (poiDto.getTipoPoi()) {
            case "AMMINISTRATIVO":
                return new POIAmministrativoBuilder();
            case "INTRATTENIMENTO":
                return new POIIntrattenimentoBuilder();
            case "PARCO":
                return new ParcoBuilder();
            case "MUSEO":
                return new MuseoBuilder();
            case "MONUMENTO":
                return new MonumentoBuilder();
            case "SERVIZI_UTILI":
                return new POIServiziUtiliBuilder();
            default:
                throw new IllegalArgumentException("Tipo di PoiDto non supportato");
        }
    }
}

