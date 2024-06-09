package it.unicam.cs.service;


import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.DTO.ItinerarioDto;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.proxy.ProxyService;
import it.unicam.cs.repository.*;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import jdk.jfr.Event;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j
public class ConsultazioneContenutiService implements IConsultazioneContenutiService {
    private final IPOIRepository poiRepository;
    private final IEventoRepository eventoRepository;
    private final IItinerarioRepository itinerarioRepository;
    private final IContenutoMultimedialeRepository contenutoMultimedialeRepository;
    private final IComuneRepository comuneRepository;
    private final ProxyService proxyService;



    public ConsultazioneContenutiService(IPOIRepository poiRepository,
                                         IEventoRepository eventoRepository,
                                         IItinerarioRepository itinerarioRepository,
                                         IContenutoMultimedialeRepository contenutoMultimedialeRepository,
                                         IComuneRepository comuneRepository,
                                         ProxyService proxyService) {
        this.poiRepository = poiRepository;
        this.eventoRepository = eventoRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.contenutoMultimedialeRepository = contenutoMultimedialeRepository;
        this.comuneRepository = comuneRepository;
        this.proxyService = proxyService;
    }

    public Comune ottieniComuneDaId(Integer idComune){
        return comuneRepository.findById(idComune).orElse(null);
    }
    public Comune ottieniComune(String nomeComune){
        return comuneRepository.findByNome(nomeComune);
    }
    @Override
    public POI ottieniPOIdaId(Integer idPOI){
        return poiRepository.findById(idPOI).orElse(null);
    }

    @Override
    public List<PoiDto> ottieniPOIS(final Integer idComune) {
        Comune comune = proxyService.ottieniComuneDaId(idComune);
        List<POI> pois;
        if(comune != null){
            pois = proxyService.ottieniPOI(comune.getNome());
            log.info("Ho trovato dei poi nella cache");
            return pois.stream()
                    .map(poi -> poiRepository.convertiPOIinPoiDto(poi))
                    .collect(Collectors.toList());
        }
        else{
            pois = poiRepository.findByComuneAssociatoId(idComune);
            Comune comuneAssociato = comuneRepository.findById(idComune).orElse(null);
            proxyService.aggiungiComune(comuneAssociato);
            return pois.stream()
                    .map(poi -> poiRepository.convertiPOIinPoiDto(poi))
                    .collect(Collectors.toList());
        }
    }


    @Override
    public Evento ottieniEventoDaId(Integer idEvento) {
        return eventoRepository.findById(idEvento).orElse(null);
    }

    @Override
    public List<EventoDto> ottieniEventi(final Integer idComune) {
        Comune comune = proxyService.ottieniComuneDaId(idComune);
        List<Evento> eventi;
        if(comune != null){
            eventi = proxyService.ottieniEventi(comune.getNome());
            return eventi.stream()
                    .map(evento -> eventoRepository.convertiEventoInEventoDTO(evento))
                    .collect(Collectors.toList());
        }
        else{
            eventi = eventoRepository.findByComuneAssociatoId(idComune);
            Comune comuneAssociato = comuneRepository.findById(idComune).orElse(null);
            proxyService.aggiungiComune(comuneAssociato);
            return eventi.stream()
                    .map(evento -> eventoRepository.convertiEventoInEventoDTO(evento))
                    .collect(Collectors.toList());
        }

    }


    @Override
    public Itinerario ottieniItinerarioDaId(Integer idItinerario){
        return itinerarioRepository.findById(idItinerario).orElse(null);
    }

    @Override
    public List<ItinerarioDto> ottieniItinerari(final Integer idComune) {
        Comune comune = proxyService.ottieniComuneDaId(idComune);
        List<Itinerario> itinerari;
        if(comune != null){
            itinerari = proxyService.ottieniItinerari(comune.getNome());

            return itinerari.stream()
                    .map(itinerario -> itinerarioRepository.convertiItinerarioAItinerarioDto(itinerario))
                    .collect(Collectors.toList());
        }
        else{
            itinerari = itinerarioRepository.findByComuneAssociatoId(idComune);
            Comune comuneAssociato = comuneRepository.findById(idComune).orElse(null);
            proxyService.aggiungiComune(comuneAssociato);
            return itinerari.stream()
                    .map(itinerario -> itinerarioRepository.convertiItinerarioAItinerarioDto(itinerario))
                    .collect(Collectors.toList());
        }
    }


    @Override
    public ContenutoMultimediale ottieniContenutoMultimedialeDaId(Integer id) {
        return contenutoMultimedialeRepository.findById(id).orElse(null);
    }

    @Override
    public List<ContenutoMultimediale> ottieniCotenutiMultimedialiPOI(Integer idPOI) {
        Iterable<ContenutoMultimediale> it = contenutoMultimedialeRepository.findAll();
        List<ContenutoMultimediale> contenutiMultimediali = new ArrayList<>();
        for(ContenutoMultimediale cont : it){
            if(cont.getPoiAssociato().getId().equals(idPOI))
                contenutiMultimediali.add(cont);
        }
        return contenutiMultimediali;
    }
}
