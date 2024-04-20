package it.unicam.cs.service.ControlloPOIService;

import it.unicam.cs.model.DTO.ParcoDto;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlloParcoService extends ControlloPOIService {
    @Autowired
    private ValidationPOIExtension validationPOIExtension;

    public void controllaPOISpecifico(PoiDto poiDto){
        ParcoDto parcoDto = (ParcoDto) poiDto;
        validationPOIExtension.isOrariAperturaValido(parcoDto.getOrarioApertura());
        validationPOIExtension.isEstensioneValida(parcoDto.getEstensione());
    }
}
