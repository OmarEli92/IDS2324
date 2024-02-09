package it.unicam.cs.service;


import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;

import java.util.List;
import java.util.Map;

public class ConsultazioneContenutiService implements IConsultazioneContenutiService {
    private final IConsultazioneContenutiService consultazioneContenutiService;


    public ConsultazioneContenutiService(IConsultazioneContenutiService consultazioneContenutiService) {
        this.consultazioneContenutiService = consultazioneContenutiService;
    }

    @Override
    public POI ottieniPOIdaId(String idPOI){
        return null;
    }

    @Override
    public List<POI> ottieniPOIS(final String idComune) {
        return null;
    }

    @Override
    public Evento ottieniEventoDaId(String idEvento) {
    return null;
    }

    @Override
    public List<Evento> ottieniEventi(final String idComune) {
        return null;
    }

    @Override
    public Itinerario ottieniItinerarioDaId(String idItinerario){
        return null;
    }

    @Override
    public List<Itinerario> ottieniItinerari(final String idComune) {
        return null;
    }

    @Override
    public ContenutoMultimediale ottieniContenutoMultimedialeDaId(String id) {
        return null;
    }

    @Override
    public List<ContenutoMultimediale> ottieniCotenutiMultimedialiPOI(String idPOI) {
        return null;
    }
}
