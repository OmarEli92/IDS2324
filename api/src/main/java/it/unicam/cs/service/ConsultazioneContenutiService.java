package it.unicam.cs.service;


import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.Interfaces.IEventoRepository;
import it.unicam.cs.repository.Interfaces.IItinerarioRepository;
import it.unicam.cs.repository.Interfaces.IPOIRepository;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import java.util.Map;

public class ConsultazioneContenutiService implements IConsultazioneContenutiService {

    private final IPOIRepository IPOIRepository;
    private final IItinerarioRepository IItinerarioRepository;
    private final IEventoRepository IEventoRepository;

    public ConsultazioneContenutiService(IPOIRepository IPOIRepository, IItinerarioRepository IItinerarioRepository,
                                         IEventoRepository IEventoRepository) {
        this.IPOIRepository = IPOIRepository;
        this.IItinerarioRepository = IItinerarioRepository;
        this.IEventoRepository = IEventoRepository;
    }

    @Override
    public POI ottieniPOIdaId(int idPOI){
            return IPOIRepository.ottieniPOIdaID(idPOI);
    }

    @Override
    public Map<Integer, POI> ottieniPOIS(final int idComune) {
        return IPOIRepository.ottieniPOIS(idComune);
    }

    @Override
    public Evento ottieniEventoDaId(int idEvento) {
        return IEventoRepository.ottieniEventoDaID(idEvento);
    }

    @Override
    public Map<Integer, Evento> ottieniEventi(final int idComune) {
        return IEventoRepository.ottieniEventi(idComune);
    }

    @Override
    public Itinerario ottieniItinerarioDaId(int idItinerario){
        return IItinerarioRepository.ottieniItinerarioDaID(idItinerario);
    }

    @Override
    public Map<Integer, Itinerario> ottieniItinerari(final int idComune) {
        return IItinerarioRepository.ottieniItinerari(idComune);
    }
}
