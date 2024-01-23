package it.unicam.cs.service;

import it.unicam.cs.exception.POINotFoundException;
import it.unicam.cs.model.*;
import it.unicam.cs.repository.ContenutoMultimedialeRepository;
import it.unicam.cs.repository.EventoRepository;
import it.unicam.cs.repository.ItinerarioRepository;
import it.unicam.cs.repository.POIRepository;
import it.unicam.cs.service.abstractions.IInserimentoContenutiService;

public class InserimentoContenutiService implements IInserimentoContenutiService {
    private POIRepository poiRepository;
    private EventoRepository eventoRepository;
    private ItinerarioRepository itinerarioRepository;
    private ContenutoMultimedialeRepository contenutoMultimedialeRepository;

    public InserimentoContenutiService(POIRepository poiRepository,EventoRepository eventoRepository,ItinerarioRepository itinerarioRepository) {
        this.poiRepository = poiRepository;
        this.eventoRepository=eventoRepository;
        this.itinerarioRepository=itinerarioRepository;
    }

    @Override
    public void aggiungiEvento(Evento evento) {
    Utente utente=evento.getUtenteAssociato();
    if(utente instanceof Contributor){
        if(((Contributor) utente).getRuolo().toString()=="contributore"){
            this.eventoRepository.aggiungiEventoInPending(evento);
            evento.getPoiAssociato().getComuneAssociato().getCuratore().verificaContenuto();;
        }
        else
            this.eventoRepository.aggiungiEventoInPending(evento);
    }
    }

    @Override
    public void aggiungiItinerario(Itinerario itinerario) throws POINotFoundException {
        for(POI poi : itinerario.getPuntiDiInteresse())
            poi.getComuneAssociato().verificaCoordinate(poi);
        Utente utente=itinerario.getUtenteAssociato();
        if(utente instanceof Contributor){
            if(((Contributor) utente).getRuolo().toString()=="contributore"){
                this.itinerarioRepository.aggiungiItinerrarioInPending(itinerario);
                itinerario.getComuneAssociato().getCuratore().verificaContenuto();
            }
        }
        else
            this.itinerarioRepository.aggiungiItinerario(itinerario);
    }

    @Override
    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        Utente utente=contenutoMultimediale.getUtenteAssociato();
        if(utente instanceof Contributor){
            if(((Contributor) utente).getRuolo().toString()=="contributore"){
                this.contenutoMultimedialeRepository.aggiungiContenutoMultimedialeInPending(contenutoMultimediale);
                contenutoMultimediale.getPoiAssociato().getComuneAssociato().getCuratore().verificaContenuto();
            }
        }
        else
            this.contenutoMultimedialeRepository.aggiungiContenutoMultimediale(contenutoMultimediale);
    }

    @Override
    public void aggiungiPOI(POI poi) throws POINotFoundException {
    poi.getComuneAssociato().verificaCoordinate(poi);
    if(poi.getUtenteAssociato() instanceof Contributor){
        if (((Contributor) poi.getUtenteAssociato()).getRuolo().toString()=="contributore") {
            this.poiRepository.aggiungiPOIInPending(poi);
            poi.getComuneAssociato().getCuratore().verificaContenuto();
        }
    }
    else
        this.poiRepository.aggiungiPOI(poi);
    }
}
