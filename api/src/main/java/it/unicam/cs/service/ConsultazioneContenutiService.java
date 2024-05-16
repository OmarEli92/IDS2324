package it.unicam.cs.service;


import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.EventoDto;
import it.unicam.cs.model.DTO.input.ItinerarioDto;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.repository.*;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultazioneContenutiService implements IConsultazioneContenutiService {
    private final IPOIRepository poiRepository;
    private final IEventoRepository eventoRepository;
    private final IItinerarioRepository itinerarioRepository;
    private final IContenutoMultimedialeRepository contenutoMultimedialeRepository;
    private final IComuneRepository comuneRepository;
    private final IContenutoContestRepository contenutoContestRepository;


    public ConsultazioneContenutiService(IPOIRepository poiRepository,
                                         IEventoRepository eventoRepository,
                                         IItinerarioRepository itinerarioRepository,
                                         IContenutoMultimedialeRepository contenutoMultimedialeRepository,
                                         IComuneRepository comuneRepository,IContenutoContestRepository contenutoContestRepository) {
        this.poiRepository = poiRepository;
        this.eventoRepository = eventoRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.contenutoMultimedialeRepository = contenutoMultimedialeRepository;
        this.comuneRepository = comuneRepository;
        this.contenutoContestRepository=contenutoContestRepository;
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
    public List<PoiDto> ottieniPOIS(final Integer comuneId) {
        List<POI> pois = poiRepository.findByComuneAssociatoId(comuneId);
        return pois.stream()
                .map(poi -> poiRepository.convertiPOIinPoiDto(poi))
                .collect(Collectors.toList());
    }


    @Override
    public Evento ottieniEventoDaId(Integer idEvento) {
        return eventoRepository.findById(idEvento).orElse(null);
    }

    @Override
    public List<EventoDto> ottieniEventi(final Integer idComune) {
        List<Evento> eventi = eventoRepository.findByComuneAssociatoId(idComune);
        return eventi.stream()
                .map(evento -> eventoRepository.convertiEventoInEventoDTO(evento))
                .collect(Collectors.toList());
    }


    @Override
    public Itinerario ottieniItinerarioDaId(Integer idItinerario){
        return itinerarioRepository.findById(idItinerario).orElse(null);
    }

    @Override
    public List<ItinerarioDto> ottieniItinerari(final Integer idComune) {
        List<Itinerario> itinerari = itinerarioRepository.findByComuneAssociatoId(idComune);
        return itinerari.stream()
                .map(itinerario -> itinerarioRepository.convertiItinerarioAItinerarioDto(itinerario))
                .collect(Collectors.toList());
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
    public ContenutoContest ottieniContenutoContestDaid(Integer idContenutoContest){
        return contenutoContestRepository.getReferenceById(idContenutoContest);
    }

}
