package it.unicam.cs.service;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.ContenutoMultimedialeRepositoryImpl;
import it.unicam.cs.repository.EventoRepositoryImpl;
import it.unicam.cs.repository.ItinerarioRepositoryImpl;
import it.unicam.cs.repository.POIRepositoryImpl;

public class ServiceInserimentoContenutiInPending {
    private final POIRepositoryImpl poiRepository;
    private final ItinerarioRepositoryImpl itinerarioRepository;
    private final EventoRepositoryImpl eventoRepository;
    private final ContenutoMultimedialeRepositoryImpl contenutoMultimedialeRepository;

    public ServiceInserimentoContenutiInPending(POIRepositoryImpl poiRepository, ItinerarioRepositoryImpl itinerarioRepository, EventoRepositoryImpl eventoRepository, ContenutoMultimedialeRepositoryImpl contenutoMultimedialeRepository) {
        this.poiRepository = poiRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.eventoRepository = eventoRepository;
        this.contenutoMultimedialeRepository = contenutoMultimedialeRepository;
    }

    public void inserisciPOIInPending(POI poi) {
       this.poiRepository.aggiungiPOIInPending(poi);
    }

    public void inserisciEventoInPending(Evento evento) {
       this.eventoRepository.aggiungiEventoInPending(evento);
    }

    public void inserisciItinerarioInPending(Itinerario itinerario) {
        this.itinerarioRepository.aggiungiItinerarioInPending(itinerario);
    }

    public void inserisciContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale) {
        this.contenutoMultimedialeRepository.aggiungiContenutoMultimedialeInPending(contenutoMultimediale);
    }
}
