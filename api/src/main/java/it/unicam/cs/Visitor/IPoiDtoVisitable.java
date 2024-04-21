package it.unicam.cs.Visitor;

import it.unicam.cs.model.DTO.PoiDto;
import org.springframework.stereotype.Component;

@Component
public interface IPoiDtoVisitable {
    public void accept(IPoiDtoVisitor iPoiDtoVisitor);
}
