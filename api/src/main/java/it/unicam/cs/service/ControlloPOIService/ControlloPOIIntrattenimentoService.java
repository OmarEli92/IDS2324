package it.unicam.cs.service.ControlloPOIService;

import it.unicam.cs.model.DTO.PoiIntrattenimentoDto;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor @NoArgsConstructor
public class ControlloPOIIntrattenimentoService {
    private ValidationPOIExtension validationPOIExtension;

    public void controllaPOIIntrattenimento(PoiIntrattenimentoDto poiIntrattenimentoDto){

        validationPOIExtension.isOrariAperturaValido(poiIntrattenimentoDto.getOrariApertura());
        validationPOIExtension.areContattiValidi(poiIntrattenimentoDto.getContatti());
    }
}
