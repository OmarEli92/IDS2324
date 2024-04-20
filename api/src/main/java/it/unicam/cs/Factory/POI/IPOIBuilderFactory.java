package it.unicam.cs.Factory.POI;

import it.unicam.cs.Builder.POIBUILDER.*;
import it.unicam.cs.model.DTO.PoiDto;
import org.springframework.stereotype.Component;

@Component
public interface IPOIBuilderFactory {
    POIBuilder creaBuilder(PoiDto poiDto);
}
