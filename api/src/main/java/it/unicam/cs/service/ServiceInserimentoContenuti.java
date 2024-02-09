package it.unicam.cs.service;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.ContenutoMultimedialeRepository;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;

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

    public void inserisciPOI(POI poi) {
        poiRepository.save(poi);
    }

    public void inserisciEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    public void inserisciItinerario (Itinerario itinerario){
        itinerarioRepository.save(itinerario);
    }

    public void inserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        contenutoMultimedialeRepository.save(contenutoMultimediale);
    }
}
