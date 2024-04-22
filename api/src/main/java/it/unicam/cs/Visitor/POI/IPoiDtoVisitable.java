package it.unicam.cs.Visitor.POI;

import org.springframework.stereotype.Component;

@Component
public interface IPoiDtoVisitable {
    public void accept(IPoiDtoVisitor iPoiDtoVisitor);
}
