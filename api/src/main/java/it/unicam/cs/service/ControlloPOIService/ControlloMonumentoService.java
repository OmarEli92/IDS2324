package it.unicam.cs.service.ControlloPOIService;

import it.unicam.cs.model.DTO.MonumentoDto;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ControlloMonumentoService extends ControlloPOIService{
    @Autowired
    private ValidationPOIExtension validationPOIExtension;
    @Override
    public void controllaPOISpecifico(PoiDto poiDto) {
        MonumentoDto monumentoDto = (MonumentoDto) poiDto;
        validationPOIExtension.isAnnoRealizzazioneValid(monumentoDto.getAnnoRealizzazione());
        validationPOIExtension.isDescrizioneValid(monumentoDto.getDescrizione());
        validationPOIExtension.isAutoreValid(monumentoDto.getAutore());
        validationPOIExtension.isAltezzaValid(monumentoDto.getAltezza());
        validationPOIExtension.isLunghezzaValid(monumentoDto.getLunghezza());
        validationPOIExtension.isArchitetturaValid(monumentoDto.getArchitettura());
    }
}
