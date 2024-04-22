package it.unicam.cs.service.ControlloService;

import it.unicam.cs.Visitor.Evento.IEventoDtoVisitor;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.util.Extensions.ValidationEventoExtension;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlloEventoService {
    @Autowired
    private ValidationEventoExtension validationEventoExtension;
    @Autowired
    private IEventoDtoVisitor eventoDtoVisitor;

    public void verificaEvento(EventoDto eventoDto){
        validationEventoExtension.isIdEventovalid(eventoDto.getIDContributore(),eventoDto.getIDPoi());
        validationEventoExtension.isEventoContributoreValid(eventoDto.getIDContributore());
        validationEventoExtension.isNomeValid(eventoDto.getNome());

    }
}
