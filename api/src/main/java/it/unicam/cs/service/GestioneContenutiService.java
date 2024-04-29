package it.unicam.cs.service;

import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.service.Interfaces.IGestioneContenutiService;

import java.util.Collection;

public class GestioneContenutiService implements IGestioneContenutiService {
    private final IPOIRepository poiRepository;
    private final IEventoRepository eventoRepository;
    private final IItinerarioRepository itinerarioRepository;

    public GestioneContenutiService(IPOIRepository poiRepository, IItinerarioRepository itinerarioRepository,
                                    IEventoRepository eventoRepository) {
        this.poiRepository = poiRepository;
        this.eventoRepository = eventoRepository;
        this.itinerarioRepository = itinerarioRepository;
    }

    @Override
    public Collection<POI> ottieniContenutiInPending() {
        return null;
    }

    @Override
    public void accettaContenuto() {

    }
}