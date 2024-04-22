package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Factory.Evento.IEventoBuilderFactory;
import it.unicam.cs.Visitor.Evento.IEventoBuilderVisitor;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.service.ControlloService.ControlloEventoService;
import it.unicam.cs.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaricamentoEventoService {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private ControlloEventoService controlloEventoService;
    @Autowired
    private IEventoBuilderFactory eventoBuilderFactory;
    @Autowired
    private IEventoBuilderVisitor eventoBuilderVisitor;

    public void caricaEvento(EventoDto eventoDto){
        controlloEventoService.verificaEvento(eventoDto);
    }
}
