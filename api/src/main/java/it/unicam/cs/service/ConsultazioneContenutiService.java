package it.unicam.cs.service;


import it.unicam.cs.model.Abstractions.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.repository.Interfaces.EventoRepository;
import it.unicam.cs.repository.Interfaces.ItinerarioRepository;
import it.unicam.cs.repository.Interfaces.POIRepository;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
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
    public POI ottieniPOIdaId(int idPOI){
            return poiRepository.ottieniPOIdaID(idPOI);
    }

    @Override
    public Map<Integer, POI> ottieniPOIS(final int idComune) {
        return poiRepository.ottieniPOIS(idComune);
    }

    @Override
    public Evento ottieniEventoDaId(int idEvento) {
        return eventoRepository.ottieniEventoDaID(idEvento);
    }

    @Override
    public Map<Integer, Evento> ottieniEventi(final int idComune) {
        return eventoRepository.ottieniEventi(idComune);
    }

    @Override
    public Itinerario ottieniItinerarioDaId(int idItinerario){
        return itinerarioRepository.ottieniItinerarioDaID(idItinerario);
    }

    @Override
    public Map<Integer, Itinerario> ottieniItinerari(final int idComune) {
        return itinerarioRepository.ottieniItinerari(idComune);
    }
}
