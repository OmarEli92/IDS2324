package it.unicam.cs.service;

import it.unicam.cs.exception.*;
import it.unicam.cs.model.*;
import it.unicam.cs.repository.ContenutoMultimedialeRepository;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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


    private boolean verificaPOI(POI poi) {
        for (POI poi1 : this.poiRepository.findAll())
            if (poi.equals(poi1))
                return false;
        return true;
    }


    private boolean verificaEvento(Evento evento) {
        POI poi = evento.getPoiAssociato();
        for (Evento evento1 : poi.getEventiAssociati())
            if (evento.equals(evento1))
                return false;
        return true;
    }


    private boolean verificaItinerario(Itinerario itinerario) {
        for (Itinerario itinerario1 : this.itinerarioRepository.findAll())
            if (itinerario.equals(itinerario1))
                return false;
        return true;
    }


    private boolean verificaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        POI poi = contenutoMultimediale.getPoiAssociato();
        for (ContenutoMultimediale contenutoMultimediale1 : poi.getContenutiMultimediali())
            if (contenutoMultimediale.equals(contenutoMultimediale1))
                return false;
        return true;
    }

    @PostMapping("/pois")
    public ResponseEntity<Object> inserisciPOI(@RequestBody POI poi) throws POINotValidException {
        boolean verifica = verificaPOI(poi);
        if (verifica) {
            this.poiRepository.save(poi);
            return new ResponseEntity<>("POI aggiunto", HttpStatus.CREATED);
        } else
            throw new POINotValidException("il poi è già stato inserito");
    }

    @PostMapping("/pois/{POIId}/eventi")
    public ResponseEntity<Object> inserisciEvento(@PathVariable(value = "POIId") Integer POIId, @RequestBody Evento evento) throws EventoNotValidException {
        boolean verifica = verificaEvento(evento);
        if (verifica) {
            this.eventoRepository.save(evento);
            return new ResponseEntity<>("Evento aggiunto", HttpStatus.CREATED);
        } else
            throw new EventoNotValidException("l'evento è già stato inserito assocuato al poi");
    }

    @PostMapping("/itinerari")
    public ResponseEntity<Object> inserisciItinerario(@RequestBody Itinerario itinerario) throws ItinerarioNotValidException {
        boolean verifica = verificaItinerario(itinerario);
        if (verifica) {
            this.itinerarioRepository.save(itinerario);
            return new ResponseEntity<>("itinerario aggiunto", HttpStatus.CREATED);
        } else
            throw new ItinerarioNotValidException("itinerario già aggiunto");
    }

    @PostMapping("/pois/{POIId}/contenuti")
    public ResponseEntity<Object> inserisciContenutoMultimediale(@PathVariable(value = "POIId") Integer POIId, @RequestBody ContenutoMultimediale contenutoMultimediale) throws ContenutoMultimedialeNotValidException {
        boolean verifica = verificaContenutoMultimediale(contenutoMultimediale);
        if (verifica) {
            this.contenutoMultimedialeRepository.save(contenutoMultimediale);
            return new ResponseEntity<>("contenuto multimediale aggiunto", HttpStatus.CREATED);
        } else
            throw new ContenutoMultimedialeNotValidException("contenuto multimediale già aggiunto");
    }
}
