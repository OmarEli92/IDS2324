package it.unicam.cs.service;


import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.input.EventoDto;
import it.unicam.cs.model.DTO.input.ItinerarioDto;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.DTO.mappers.*;
import it.unicam.cs.model.DTO.output.*;
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
import jakarta.transaction.Transactional;
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
    private final IContestRepository contestRepository;
    private IContenutoContestRepository contenutoContestRepository;
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
    public List<POI> ottieniPOIS(final Integer idComune) {
        Comune comune = proxyService.ottieniComuneDaId(idComune);
        List<POI> pois;
        if(comune != null){
            pois = proxyService.ottieniPOI(comune.getNome());
            log.info("Ho trovato dei poi nella cache");
            return new ArrayList<>(pois);
        }
        else{
            pois = poiRepository.findByComuneAssociatoId(idComune);
            Comune comuneAssociato = comuneRepository.findById(idComune).orElse(null);
            proxyService.aggiungiComune(comuneAssociato);
            return new ArrayList<>(pois);
        }
    }


    @Override
    public Evento ottieniEventoDaId(Integer idEvento) {
        return eventoRepository.findById(idEvento).orElseThrow(() -> new EntityNotFoundException("evento inesistente"));
    }

    @Override
    public List<Evento> ottieniEventi(final Integer idComune) {
        Comune comune = proxyService.ottieniComuneDaId(idComune);
        List<Evento> eventi;
        if(comune != null){
            eventi = proxyService.ottieniEventi(comune.getNome());
            return new ArrayList<>(eventi);
        }
        else{
            eventi = eventoRepository.findByComuneAssociatoId(idComune);
            Comune comuneAssociato = comuneRepository.findById(idComune).orElse(null);
            proxyService.aggiungiComune(comuneAssociato);
            return new ArrayList<>(eventi);
        }

    }


    @Override
    public Itinerario ottieniItinerarioDaId(Integer idItinerario){
        return itinerarioRepository.findById(idItinerario).orElseThrow(() -> new EntityNotFoundException("itinerario non trovato"));
    }

    @Override
    public List<Itinerario> ottieniItinerari(final Integer idComune) {
        Comune comune = proxyService.ottieniComuneDaId(idComune);
        List<Itinerario> itinerari;
        if(comune != null){
            itinerari = proxyService.ottieniItinerari(comune.getNome());

            return new ArrayList<>(itinerari);
        }
        else{
            itinerari = itinerarioRepository.findByComuneAssociatoId(idComune);
            Comune comuneAssociato = comuneRepository.findById(idComune).orElse(null);
            proxyService.aggiungiComune(comuneAssociato);
            return new ArrayList<>(itinerari);
        }
    }


    @Override
    public ContenutoMultimediale ottieniContenutoMultimedialeDaId(Integer id) {
        return contenutoMultimedialeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("contenuto multimediale non esietente"));
    }

    @Override
    public List<ContenutoMultimediale> ottieniContenutiMultimedialiComune(Integer idComune) {
        Iterable<ContenutoMultimediale> it = contenutoMultimedialeRepository.findAll();
        List<ContenutoMultimediale> contenutiMultimediali = new ArrayList<>();
        for(ContenutoMultimediale cont : it){
            if(cont.getPoiAssociato().getId().equals(idComune))
                contenutiMultimediali.add(cont);
        }
        return new ArrayList<>(contenutiMultimediali);
    }

    @Override
    public Contest ottieniContestDaId(Integer idContest) {
        return contestRepository.findById(idContest).orElseThrow(()-> new EntityNotFoundException("contest non esistente"));
    }
    @Override
    public ContenutoContest ottieniContenutoContest(Integer id){
        return contenutoContestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("contenuto contest non trovato"));
    }
}
