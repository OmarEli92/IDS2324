package it.unicam.cs.service.ControlloService;

import it.unicam.cs.Visitor.POI.IPoiDtoVisitor;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlloPOIService {
    @Autowired
    private ValidationPOIExtension validationPOIExtension;
    @Autowired
    private IPoiDtoVisitor poiDtoVisitor;

    public void verificaPOI(PoiDto poiDto, Integer userId) {
        validationPOIExtension.isPOINomeValid(poiDto.getNome());
        validationPOIExtension.isPOIInComune(poiDto, userId);
        poiDto.accept(poiDtoVisitor);
    }

}
