package it.unicam.cs.service.ControlloPOIService;

import it.unicam.cs.model.DTO.MonumentoDto;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ControlloMonumentoService {
    private ValidationPOIExtension validationPOIExtension;

    public void controlloMonumento(MonumentoDto monumentoDto){
        validationPOIExtension.isAnnoRealizzazioneValid(monumentoDto.getAnnoRealizzazione());
        validationPOIExtension.isDescrizioneValid(monumentoDto.getDescrizione());
        validationPOIExtension.isAutoreValid(monumentoDto.getAutore());
        validationPOIExtension.isAltezzaValid(monumentoDto.getAltezza());
        validationPOIExtension.isLunghezzaValid(monumentoDto.getLunghezza());
        validationPOIExtension.isArchitetturaValid(monumentoDto.getArchitettura());
    }
}
