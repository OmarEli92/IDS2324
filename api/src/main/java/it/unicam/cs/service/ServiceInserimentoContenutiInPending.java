package it.unicam.cs.service;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.IContenutoMultimedialeInPendingRepository;
import it.unicam.cs.repository.IEventoInPendingRepository;
import it.unicam.cs.repository.IItinerarioInPendingRepository;
import it.unicam.cs.repository.IPOIInPendingRepository;

public class ServiceInserimentoContenutiInPending {
    private final IPOIInPendingRepository poiInPendingRepository;
    private final IItinerarioInPendingRepository itinerarioInPendingRepository;
    private final IEventoInPendingRepository eventoInPendingRepository;
    private final IContenutoMultimedialeInPendingRepository contenutoMultimedialeInPendingRepository;

    public ServiceInserimentoContenutiInPending(IPOIInPendingRepository poiInPendingRepository, IItinerarioInPendingRepository itinerarioInPendingRepository, IEventoInPendingRepository eventoInPendingRepository, IContenutoMultimedialeInPendingRepository contenutoMultimedialeInPendingRepository) {
        this.poiInPendingRepository = poiInPendingRepository;
        this.itinerarioInPendingRepository = itinerarioInPendingRepository;
        this.eventoInPendingRepository = eventoInPendingRepository;
        this.contenutoMultimedialeInPendingRepository = contenutoMultimedialeInPendingRepository;
    }

    public void inserisciPOIInPending(POI poi) {
        poiInPendingRepository.save(poi);
    }

    public void inserisciEventoInPending(Evento evento) {
        eventoInPendingRepository.save(evento);
    }

    public void inserisciItinerarioInPending(Itinerario itinerario) {
        itinerarioInPendingRepository.save(itinerario);
    }

    public void inserisciContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale) {
        contenutoMultimedialeInPendingRepository.save(contenutoMultimediale);
    }

}
