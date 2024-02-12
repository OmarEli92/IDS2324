package it.unicam.cs.service;


import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ConsultazioneContenutiService implements IConsultazioneContenutiService {
    private final IPOIRepository poiRepository;


    public ConsultazioneContenutiService(IPOIRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    @Override
    public POI ottieniPOIdaId(Integer idPOI){
        return poiRepository.findById(idPOI).orElse(null);
    }

    @Override
    public List<POI> ottieniPOIS(final Integer idComune) {
        return null;
    }

    @Override
    public Evento ottieniEventoDaId(Integer idEvento) {
    return null;
    }

    @Override
    public List<Evento> ottieniEventi(final Integer idComune) {
        return null;
    }

    @Override
    public Itinerario ottieniItinerarioDaId(Integer idItinerario){
        return null;
    }

    @Override
    public List<Itinerario> ottieniItinerari(final Integer idComune) {
        return null;
    }

    @Override
    public ContenutoMultimediale ottieniContenutoMultimedialeDaId(Integer id) {
        return null;
    }

    @Override
    public List<ContenutoMultimediale> ottieniCotenutiMultimedialiPOI(Integer idPOI) {
        return null;
    }
}
