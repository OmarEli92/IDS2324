package it.unicam.cs.service;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.ContenutoMultimedialeRepositoryImpl;
import it.unicam.cs.repository.EventoRepositoryImpl;
import it.unicam.cs.repository.ItinerarioRepositoryImpl;
import it.unicam.cs.repository.POIRepositoryImpl;

public class ServiceInserimentoContenuti {
    private POIRepositoryImpl poiRepository;
    private EventoRepositoryImpl eventoRepository;
    private ItinerarioRepositoryImpl itinerarioRepository;
    private ContenutoMultimedialeRepositoryImpl contenutoMultimedialeRepository;

    public ServiceInserimentoContenuti(POIRepositoryImpl poiRepository, EventoRepositoryImpl eventoRepository, ItinerarioRepositoryImpl itinerarioRepository, ContenutoMultimedialeRepositoryImpl contenutoMultimedialeRepository) {
        this.poiRepository = poiRepository;
        this.eventoRepository = eventoRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.contenutoMultimedialeRepository = contenutoMultimedialeRepository;
    }

    public void inserisciPOI(POI poi) {
        this.poiRepository.aggiungiPOI(poi);
    }

    public void inserisciEvento(Evento evento) {
        this.eventoRepository.aggiungiEvento(evento);
    }

    public void inserisciItinerario (Itinerario itinerario){
        this.itinerarioRepository.aggiungiItinerario(itinerario);
    }

    public void inserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        this.contenutoMultimedialeRepository.aggiungiContenutoMultimediale(contenutoMultimediale);
    }
}
