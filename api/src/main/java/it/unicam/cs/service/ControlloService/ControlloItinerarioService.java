package it.unicam.cs.service.ControlloService;

import it.unicam.cs.model.DTO.input.ItinerarioDto;
import it.unicam.cs.util.Extensions.ValidationItinerarioExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ControlloItinerarioService {
    @Autowired
    ValidationItinerarioExtension validationItinerarioExtension;

    public void controllaItinerario(ItinerarioDto itinerarioDto, Integer userId){
        validationItinerarioExtension.isItinerarioNomeValid(itinerarioDto.getNome());
        validationItinerarioExtension.isDescrizioneValid(itinerarioDto.getDescrizione());
        validationItinerarioExtension.areIdPOISValid(itinerarioDto.getPoisId(), userId);
    }
}
