package it.unicam.cs.service;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.*;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ServiceVerificaContenuto {
    private final IPOIRepository poiRepository;
    private final IPOIInPendingRepository poiInPendingRepository;
    private final IEventoRepository eventoRepository;
    private final IEventoInPendingRepository eventoInPendingRepository;
    private final IItinerarioRepository itinerarioRepository;
    private final IItinerarioInPendingRepository itinerarioInPendingRepository;
    private final ContenutoMultimedialeRepository contenutoMultimedialeRepository;
    private final IContenutoMultimedialeInPendingRepository contenutoMultimedialeInPendingRepository;
    //andrò a richiamare il suo metodo per aggiungere il contenuto se questo viene validato
    private final ServiceInserimentoContenuti serviceInserimentoContenuti;

    public ServiceVerificaContenuto(IPOIRepository poiRepository, IPOIInPendingRepository poiInPendingRepository, IEventoRepository eventoRepository, IEventoInPendingRepository eventoInPendingRepository, IItinerarioRepository itinerarioRepository, IItinerarioInPendingRepository itinerarioInPendingRepository, ContenutoMultimedialeRepository contenutoMultimedialeRepository, IContenutoMultimedialeInPendingRepository contenutoMultimedialeInPendingRepository, ServiceInserimentoContenuti serviceInserimentoContenuti) {
        this.poiRepository = poiRepository;
        this.poiInPendingRepository = poiInPendingRepository;
        this.eventoRepository = eventoRepository;
        this.eventoInPendingRepository = eventoInPendingRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.itinerarioInPendingRepository = itinerarioInPendingRepository;
        this.contenutoMultimedialeRepository = contenutoMultimedialeRepository;
        this.contenutoMultimedialeInPendingRepository = contenutoMultimedialeInPendingRepository;
        this.serviceInserimentoContenuti=serviceInserimentoContenuti;
    }


    public void validaPOI(POI poi) {

    }

    public void validaEvento(Evento evento) {

    }

    public void validaItinerario(Itinerario itinerario) {
    }

    public void validaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
    }

    public void invalidaPOI(POI poi){
    }

    public void invalidaEvento(Evento evento) {
    }

    public void invalidaItinerario(Itinerario itinerario) {
    }

    public void invalidaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {

    }



}