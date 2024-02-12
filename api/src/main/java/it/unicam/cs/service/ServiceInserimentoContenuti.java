package it.unicam.cs.service;

import it.unicam.cs.exception.EventoNotValidException;
import it.unicam.cs.exception.POINotFoundException;
import it.unicam.cs.exception.POINotValidException;
import it.unicam.cs.model.*;
import it.unicam.cs.repository.ContenutoMultimedialeRepository;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;

import java.util.Optional;

public class ServiceInserimentoContenuti {
    private final IPOIRepository poiRepository;
    private final IItinerarioRepository itinerarioRepository;
    private final IEventoRepository eventoRepository;
    private final ContenutoMultimedialeRepository contenutoMultimedialeRepository;

    public ServiceInserimentoContenuti(IPOIRepository poiRepository, IItinerarioRepository itinerarioRepository, IEventoRepository eventoRepository, ContenutoMultimedialeRepository contenutoMultimedialeRepository) {
        this.poiRepository = poiRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.eventoRepository = eventoRepository;
        this.contenutoMultimedialeRepository = contenutoMultimedialeRepository;
    }

    public void inserisciPOI(POI poi) throws POINotValidException {
        boolean verifica=verificaPOI(poi);
        if(verifica)
            poiRepository.save(poi);
        else
            throw new POINotValidException("il poi inserito è già presente");
    }
    private boolean verificaPOI(POI poi) {
        for(POI poi1 : this.poiRepository.findAll())
            if (poi.equals(poi1))
                return false;
        return true;
    }

    public void inserisciEvento(Evento evento) throws EventoNotValidException {
        boolean verifica=verificaEvento(evento);
        if(verifica)
            eventoRepository.save(evento);
        else
            throw new EventoNotValidException("l'evento è già stato inserito");
    }

    private boolean verificaEvento(Evento evento) {
        POI poi=evento.getPoiAssociato();
        for(Evento evento1 : poi.getEventiAssociati())
            if(evento.equals(evento1))
                return false;
        return true;
    }

    public void inserisciItinerario (Itinerario itinerario){
        boolean verifica=verificaItinerario(itinerario);
        itinerarioRepository.save(itinerario);
    }

    private boolean verificaItinerario(Itinerario itinerario) {
        for(Itinerario itinerario1 : this.itinerarioRepository.findAll())
            if(itinerario.equals(itinerario1))
                return false;
        return true;
    }

    public void inserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        contenutoMultimedialeRepository.save(contenutoMultimediale);
    }
}
