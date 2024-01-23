package it.unicam.cs.service;

import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.EventoRepository;
import it.unicam.cs.repository.ItinerarioRepository;
import it.unicam.cs.repository.POIRepository;
import it.unicam.cs.service.abstractions.IConsultazioneContenutiService;

import java.util.Map;

public class ConsultazioneContenutiService implements IConsultazioneContenutiService {

    private final POIRepository poiRepository;
    private final ItinerarioRepository itinerarioRepository;
    private final EventoRepository eventoRepository;

    public ConsultazioneContenutiService(POIRepository poiRepository, ItinerarioRepository itinerarioRepository,
                                         EventoRepository eventoRepository) {
        this.poiRepository = poiRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.eventoRepository = eventoRepository;
    }

    @Override
    public POI ottieniPOIdaId(int idPOI) {
        return null;
    }

    @Override
    public Map<Integer, POI> ottieniPOIS() {
        return null;
    }

    @Override
    public Evento ottieniEventoDaId(int idEvento) {
        return null;
    }

    @Override
    public Map<Integer, Evento> ottieniEventi() {
        return null;
    }

    @Override
    public Itinerario ottieniItinerarioDaId(int idItinerario) {
        return null;
    }

    @Override
    public Map<Integer, Itinerario> ottieniItinerari() {
        return null;
    }
}
