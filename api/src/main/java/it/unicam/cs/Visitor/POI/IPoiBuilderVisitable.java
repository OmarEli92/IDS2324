package it.unicam.cs.Visitor.POI;

import it.unicam.cs.model.DTO.input.PoiDto;
import org.springframework.stereotype.Component;

@Component
public interface IPoiBuilderVisitable {
    public void accept(IPOIBuilderVisitor ipoiBuilderVisitor, PoiDto poiDto);
}
