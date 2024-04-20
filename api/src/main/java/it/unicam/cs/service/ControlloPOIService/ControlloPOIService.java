package it.unicam.cs.service.ControlloPOIService;

import it.unicam.cs.model.DTO.*;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public abstract class ControlloPOIService {
    @Autowired
    private ValidationPOIExtension validationPOIExtension;

    public void verificaPOI(PoiDto poiDto) {
        validationPOIExtension.isPOINomeValid(poiDto.getNome());
        validationPOIExtension.isPOIContributoreValid(poiDto.getIDContributore());

    }

    public abstract void controllaPOISpecifico(PoiDto poiDto);
}
