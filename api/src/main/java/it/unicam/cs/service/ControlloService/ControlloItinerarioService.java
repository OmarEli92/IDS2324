package it.unicam.cs.service.ControlloService;

import it.unicam.cs.model.DTO.ItinerarioDto;
import it.unicam.cs.util.Extensions.ValidationItinerarioExtension;
import org.springframework.beans.factory.annotation.Autowired;

public class ControlloItinerarioService {
    @Autowired
    ValidationItinerarioExtension validationItinerarioExtension;

    public void controllaItinerario(ItinerarioDto itinerarioDto){
        validationItinerarioExtension.isItinerarioNomeValid(itinerarioDto.getNome());
        validationItinerarioExtension.isDescrizioneValid(itinerarioDto.getDescrizione());
        validationItinerarioExtension.isItinerarioContributoreValid(itinerarioDto.getIDContributore());
        validationItinerarioExtension.areIdPOISValid(itinerarioDto.getPoisId(), itinerarioDto.getIDContributore());
    }
}
