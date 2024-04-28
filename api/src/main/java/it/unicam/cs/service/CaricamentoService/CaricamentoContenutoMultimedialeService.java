package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Mediators.ContenutoMultimedialeMediator;
import it.unicam.cs.model.DTO.ContenutoMultimedialeDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.ControlloService.ControlloContenutoMultimedialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaricamentoContenutoMultimedialeService {
    @Autowired
    private ControlloContenutoMultimedialeService controlloContenutoMultimedialeService;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private IPOIRepository poiRepository;
    @Autowired
    private IEventoRepository eventoRepository;
    @Autowired
    private IItinerarioRepository itinerarioRepository;
    @Autowired
    private ContenutoMultimedialeMediator contenutoMultimedialeMediator;

    public void caricaContenutoMultimediale(ContenutoMultimedialeDto contenutoMultimedialeDto){
        controlloContenutoMultimedialeService.verificaContenutoMultimediale(contenutoMultimedialeDto);
        ContenutoMultimediale contenutoMultimediale = new ContenutoMultimediale();
        costruisciContenutoMultimediale(contenutoMultimediale,contenutoMultimedialeDto);
        contenutoMultimedialeMediator.salvaContenutoMultimediale(contenutoMultimediale);
    }

    private void costruisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale,ContenutoMultimedialeDto contenutoMultimedialeDto) {
        Utente utente = utenteRepository.findUtenteById(contenutoMultimedialeDto.getIdContributore());
        POI poi = poiRepository.getReferenceById(contenutoMultimedialeDto.getIdPoi());
        Evento evento = eventoRepository.getReferenceById(contenutoMultimedialeDto.getIdEvento());
        Itinerario itinerario = itinerarioRepository.getReferenceById(contenutoMultimedialeDto.getIdItinerario());
        contenutoMultimediale.setNome(contenutoMultimedialeDto.getNome());
        contenutoMultimediale.setUtenteCreatore(utente);
        contenutoMultimediale.setStato(utente);
        setElementoComuneAssociato(poi,evento,itinerario,contenutoMultimediale);
    }

    private void setElementoComuneAssociato(POI poi, Evento evento, Itinerario itinerario, ContenutoMultimediale contenutoMultimediale) {
        if(poi == null && evento == null && itinerario == null){
            throw new IllegalArgumentException("l'elemento del comune deve essere settato");
        }
        else if((poi != null && evento != null && itinerario != null) ||
                (poi != null && evento != null) || (evento != null && itinerario != null) ||
                (poi != null && itinerario != null)){
            throw new IllegalArgumentException("ci deve essere un solo elemento del comune settato");
        }
        else if(poi != null){
            contenutoMultimediale.setPoiAssociato(poi);
        }
        else if(evento != null){
            contenutoMultimediale.setEventoAssociato(evento);
        }
        else if(itinerario != null){
            contenutoMultimediale.setItinerarioAssociato(itinerario);
        }
    }
}
