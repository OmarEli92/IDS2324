package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Builder.EVENTOBUILDER.EventoBuilder;
import it.unicam.cs.Factory.Evento.IEventoBuilderFactory;
import it.unicam.cs.Mediators.EventoMediator;
import it.unicam.cs.Visitor.Evento.IEventoBuilderVisitor;
import it.unicam.cs.exception.UtenteNotValidException;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.EventoDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.service.CaricamentoService.Interfaces.ICaricamentoEventoService;
import it.unicam.cs.service.ConsultazioneContenutiService;
import it.unicam.cs.service.ControlloService.ControlloEventoService;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaricamentoEventoService implements ICaricamentoEventoService {
    @Autowired
    private IUtenteService utenteService;
    @Autowired
    private ControlloEventoService controlloEventoService;
    @Autowired
    private IEventoBuilderFactory eventoBuilderFactory;
    @Autowired
    private IEventoBuilderVisitor eventoBuilderVisitor;
    @Autowired
    private IConsultazioneContenutiService consultazioneContenutiService;
    @Autowired
    private EventoMediator eventoMediator;
    @Override
    public void caricaEvento(EventoDto eventoDto){
        controlloEventoService.verificaEvento(eventoDto);
        EventoBuilder eventoBuilder = eventoBuilderFactory.creaBuilder(eventoDto);
        costrusciEvento(eventoBuilder,eventoDto);
        eventoMediator.salvaEvento(eventoBuilder.build());
    }
    @Transactional
    private void costrusciEvento(EventoBuilder eventoBuilder, EventoDto eventoDto) {
        Utente utente = utenteService.ottieniUtenteById(eventoDto.getIdContributore());
        Comune comune = utente.getComuneAssociato();
        StatoElemento statoElemento;
        List<String> nomi = utente.getRuoli()
                        .stream()
                        .map(Ruolo::getNome)
                        .collect(Collectors.toList());
        if(nomi.contains(RuoliUtente.CURATORE.name()) || nomi.contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO.name())){
            statoElemento = StatoElemento.PUBBLICATO;
        }
        else{
            statoElemento = StatoElemento.PENDING;
        }
        boolean attivo;
        if(LocalDateTime.now().isEqual(eventoDto.getDataInizio())){
            attivo = true;
        }
        else {
            attivo = false;
        }
        eventoBuilder.setNome(eventoDto.getNome());
        eventoBuilder.setDescrizione(eventoDto.getDescrizione());
        eventoBuilder.setAttivo(attivo);
        eventoBuilder.setContributore(utente);
        eventoBuilder.setStato(statoElemento);
        eventoBuilder.setPoiAssociato(consultazioneContenutiService.ottieniPOIdaId(eventoDto.getIdPoi()));
        eventoBuilder.setComuneAssociato(utente.getComuneAssociato());
        eventoBuilder.setContenutiMultimediali(new ArrayList<ContenutoMultimediale>());
        eventoBuilder.accept(eventoBuilderVisitor,eventoDto);
    }
}
