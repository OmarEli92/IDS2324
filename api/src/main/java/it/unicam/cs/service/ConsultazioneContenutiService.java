package it.unicam.cs.service;


import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.repository.IContenutoMultimedialeRepository;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultazioneContenutiService implements IConsultazioneContenutiService {
    private final IPOIRepository poiRepository;
    private final IEventoRepository eventoRepository;
    private final IItinerarioRepository itinerarioRepository;
    private final IContenutoMultimedialeRepository contenutoMultimedialeRepository;


    public ConsultazioneContenutiService(IPOIRepository poiRepository,
                                         IEventoRepository eventoRepository,
                                         IItinerarioRepository itinerarioRepository,
                                         IContenutoMultimedialeRepository contenutoMultimedialeRepository) {
        this.poiRepository = poiRepository;
        this.eventoRepository = eventoRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.contenutoMultimedialeRepository = contenutoMultimedialeRepository;
    }

    @Override
    public POI ottieniPOIdaId(Integer idPOI){
        return poiRepository.findById(idPOI).orElse(null);
    }

    @Override
    public List<POI> ottieniPOIS(final Integer idComune) {
         Iterable<POI> it = poiRepository.findAll();
         List<POI> pois = new ArrayList<>();
         for(POI poi : it){
             if(poi.getComuneAssociato().getId().equals(idComune))
                    pois.add(poi);
         }
         return pois;
    }

    @Override
    public Evento ottieniEventoDaId(Integer idEvento) {
        return eventoRepository.findById(idEvento).orElse(null);
    }

    @Override
    public List<Evento> ottieniEventi(final Integer idComune) {
        Iterable<Evento> it = eventoRepository.findAll();
        List<Evento> eventi = new ArrayList<>();
        for(Evento evento : it){
            if(evento.getComuneAssociato().getId().equals(idComune))
                eventi.add(evento);
        }
        return eventi;
    }

    @Override
    public Itinerario ottieniItinerarioDaId(Integer idItinerario){
        return itinerarioRepository.findById(idItinerario).orElse(null);
    }

    @Override
    public List<Itinerario> ottieniItinerari(final Integer idComune) {
        Iterable<Itinerario> it = itinerarioRepository.findAll();
        List<Itinerario> itinerari = new ArrayList<>();
        for(Itinerario itinerario : it){
            if(itinerario.getComuneAssociato().getId().equals(idComune))
                itinerari.add(itinerario);
        }
        return itinerari;
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
