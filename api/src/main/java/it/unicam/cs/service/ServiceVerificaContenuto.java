package it.unicam.cs.service;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.ContenutoMultimedialeRepositoryImpl;
import it.unicam.cs.repository.EventoRepositoryImpl;
import it.unicam.cs.repository.Interfaces.ContenutoMultimedialeRepository;
import it.unicam.cs.repository.Interfaces.IEventoRepository;
import it.unicam.cs.repository.Interfaces.IItinerarioRepository;
import it.unicam.cs.repository.Interfaces.IPOIRepository;
import it.unicam.cs.repository.ItinerarioRepositoryImpl;
import it.unicam.cs.repository.POIRepositoryImpl;

import java.util.List;

public class ServiceVerificaContenuto {
private ContenutoMultimedialeRepositoryImpl contenutoMultimedialeRepository;
private ItinerarioRepositoryImpl itinerarioRepository;
private POIRepositoryImpl poiRepository;
private EventoRepositoryImpl eventoRepository;

    public ServiceVerificaContenuto(ContenutoMultimedialeRepositoryImpl contenutoMultimedialeRepository, ItinerarioRepositoryImpl itinerarioRepository, POIRepositoryImpl poiRepository, EventoRepositoryImpl eventoRepository) {
        this.contenutoMultimedialeRepository = contenutoMultimedialeRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.poiRepository = poiRepository;
        this.eventoRepository = eventoRepository;
    }

    public void validaPOI(POI poi) {
        this.poiRepository.rimuoviPOIInPenidng(poi);
        this.poiRepository.aggiungiPOI(poi);
    }

    public void validaEvento(Evento evento) {
        this.eventoRepository.rimuoviEventoInPending(evento);
        this.eventoRepository.aggiungiEvento(evento);
    }

    public void validaItinerario(Itinerario itinerario) {
        this.itinerarioRepository.rimuoviItinerarioInPending(itinerario);
    }

    public void validaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        this.contenutoMultimedialeRepository.rimuoviContenutoMultimedialeInPending(contenutoMultimediale);
        this.contenutoMultimedialeRepository.aggiungiContenutoMultimediale(contenutoMultimediale);
    }

    public void invalidaPOI(POI poi){
        this.poiRepository.rimuoviPOIInPenidng(poi);
    }

    public void invalidaEvento(Evento evento) {
        this.eventoRepository.rimuoviEventoInPending(evento);
    }

    public void invalidaItinerario(Itinerario itinerario) {
        this.itinerarioRepository.rimuoviItinerarioInPending(itinerario);
    }

    public void invalidaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        this.contenutoMultimedialeRepository.rimuoviContenutoMultimedialeInPending(contenutoMultimediale);
    }

    public void verificaPOI(POI poi) {
    poi.getComuneAssociato().verificaCoordinate(poi);
    }

    public void verificaEvento(Evento evento) {
        evento.getPoiAssociato().verificaEvento(evento);
    }

    public void verificaItinerario(Itinerario itinerario) {

    }

    public void verificaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        contenutoMultimediale.getPoiAssociato().verificaContenutoMultimediale(contenutoMultimediale);
    }
}
