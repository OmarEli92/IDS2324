package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Builder.EVENTOBUILDER.EventoBuilder;
import it.unicam.cs.Builder.POIBUILDER.POIBuilder;
import it.unicam.cs.Factory.Evento.IEventoBuilderFactory;
import it.unicam.cs.Visitor.Evento.IEventoBuilderVisitor;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.service.ConsultazioneContenutiService;
import it.unicam.cs.service.ControlloService.ControlloEventoService;
import it.unicam.cs.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    @Autowired
    private ConsultazioneContenutiService consultazioneContenutiService;

    public void caricaEvento(EventoDto eventoDto){
        controlloEventoService.verificaEvento(eventoDto);
        EventoBuilder eventoBuilder = eventoBuilderFactory.creaBuilder(eventoDto);
        costrusciEvento(eventoBuilder,eventoDto);
    }
    private void costrusciEvento(EventoBuilder eventoBuilder, EventoDto eventoDto) {
        eventoBuilder.setNome(eventoDto.getNome());
        eventoBuilder.setPosizione(eventoDto.getPosizione());
        eventoBuilder.setContributore(utenteService.ottieniUtenteById(eventoDto.getIDContributore()));
        eventoBuilder.setPoiAssociato(consultazioneContenutiService.ottieniPOIdaId(eventoDto.getIDPoi()));
        eventoBuilder.setComuneAssociato(utenteService.ottieniUtenteById(eventoDto.getIDContributore()).getComuneAssociato());
        eventoBuilder.setContenutiMultimediali(new ArrayList<ContenutoMultimediale>());
        eventoBuilder.accept(eventoBuilderVisitor,eventoDto);
    }
}
