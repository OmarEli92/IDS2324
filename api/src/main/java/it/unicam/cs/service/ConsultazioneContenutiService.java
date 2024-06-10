package it.unicam.cs.service;


import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.EventoDto;
import it.unicam.cs.model.DTO.input.ItinerarioDto;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.DTO.mappers.*;
import it.unicam.cs.model.DTO.output.ContenutoMultimedialeOutputDto;
import it.unicam.cs.model.DTO.output.EventoOutputDto;
import it.unicam.cs.model.DTO.output.ItinerarioOutputDto;
import it.unicam.cs.model.DTO.output.PoiOutpuDto;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.proxy.ProxyService;
import it.unicam.cs.repository.*;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import jdk.jfr.Event;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ConsultazioneContenutiService implements IConsultazioneContenutiService {
    private IPOIRepository poiRepository;
    private IEventoRepository eventoRepository;
    private IItinerarioRepository itinerarioRepository;
    private IContenutoMultimedialeRepository contenutoMultimedialeRepository;
    private IComuneRepository comuneRepository;
    private IContenutoContestRepository contenutoContestRepository;
    private PoiDtoMapper poiDtoMapper;
    private ItinerarioDtoMapper itinerarioDtoMapper;
    private EventoDtoMapper eventoDtoMapper;
    private ContenutoMultimedialeDtoMapper contenutoMultimedialeDtoMapper;
    private ContenutoContestDtoMapper contenutoContestDtoMapper;
    private ProxyService proxyService;

    public Comune ottieniComuneDaId(Integer idComune){
        return comuneRepository.findById(idComune).orElseThrow(() -> new EntityNotFoundException("comune non esistente"));
    }
    public Comune ottieniComune(String nomeComune){
        return comuneRepository.findByNome(nomeComune);
    }
    @Override
    public POI ottieniPOIdaId(Integer idPOI){
        return poiRepository.findById(idPOI).orElseThrow(() -> new EntityNotFoundException("poi non esistente"));
    }

    @Override
    public List<PoiOutpuDto> ottieniPOIS(final Integer idComune) {
        Comune comune = proxyService.ottieniComuneDaId(idComune);
        List<POI> pois;
        if(comune != null){
            pois = proxyService.ottieniPOI(comune.getNome());
            log.info("Ho trovato dei poi nella cache");
            return pois.stream()
                    .map(poiDtoMapper)
                    .collect(Collectors.toList());
        }
        else{
            pois = poiRepository.findByComuneAssociatoId(idComune);
            Comune comuneAssociato = comuneRepository.findById(idComune).orElse(null);
            proxyService.aggiungiComune(comuneAssociato);
            return pois.stream()
                    .map(poiDtoMapper)
                    .collect(Collectors.toList());
        }
    }


    @Override
    public Evento ottieniEventoDaId(Integer idEvento) {
        return eventoRepository.findById(idEvento).orElseThrow(() -> new EntityNotFoundException("evento inesistente"));
    }

    @Override
    public List<EventoOutputDto> ottieniEventi(final Integer idComune) {
        Comune comune = proxyService.ottieniComuneDaId(idComune);
        List<Evento> eventi;
        if(comune != null){
            eventi = proxyService.ottieniEventi(comune.getNome());
            return eventi.stream()
                    .map(eventoDtoMapper)
                    .collect(Collectors.toList());
        }
        else{
            eventi = eventoRepository.findByComuneAssociatoId(idComune);
            Comune comuneAssociato = comuneRepository.findById(idComune).orElse(null);
            proxyService.aggiungiComune(comuneAssociato);
            return eventi.stream()
                    .map(eventoDtoMapper)
                    .collect(Collectors.toList());
        }

    }


    @Override
    public Itinerario ottieniItinerarioDaId(Integer idItinerario){
        return itinerarioRepository.findById(idItinerario).orElseThrow(() -> new EntityNotFoundException("itinerario non trovato"));
    }

    @Override
    public List<ItinerarioOutputDto> ottieniItinerari(final Integer idComune) {
        Comune comune = proxyService.ottieniComuneDaId(idComune);
        List<Itinerario> itinerari;
        if(comune != null){
            itinerari = proxyService.ottieniItinerari(comune.getNome());

            return itinerari.stream()
                    .map(itinerarioDtoMapper)
                    .collect(Collectors.toList());
        }
        else{
            itinerari = itinerarioRepository.findByComuneAssociatoId(idComune);
            Comune comuneAssociato = comuneRepository.findById(idComune).orElse(null);
            proxyService.aggiungiComune(comuneAssociato);
            return itinerari.stream()
                    .map(itinerarioDtoMapper)
                    .collect(Collectors.toList());
        }
    }


    @Override
    public ContenutoMultimediale ottieniContenutoMultimedialeDaId(Integer id) {
        return contenutoMultimedialeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("contenuto multimediale non esietente"));
    }

    @Override
    public List<ContenutoMultimedialeOutputDto> ottieniContenutiMultimedialiPOI(Integer idPOI) {
        Iterable<ContenutoMultimediale> it = contenutoMultimedialeRepository.findAll();
        List<ContenutoMultimediale> contenutiMultimediali = new ArrayList<>();
        for(ContenutoMultimediale cont : it){
            if(cont.getPoiAssociato().getId().equals(idPOI))
                contenutiMultimediali.add(cont);
        }
        return contenutiMultimediali.stream()
                .map(contenutoMultimedialeDtoMapper)
                .collect(Collectors.toList());
    }
    @Override
    public ContenutoContest ottieniContenutoContestDaid(Integer idContenutoContest){
        return contenutoContestRepository.findById(idContenutoContest).orElseThrow(() -> new EntityNotFoundException("contenuto contest non trovato"));
    }

}
