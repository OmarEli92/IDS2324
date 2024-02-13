package it.unicam.cs.service;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.IContenutoMultimedialeInPendingRepository;
import it.unicam.cs.repository.IEventoInPendingRepository;
import it.unicam.cs.repository.IItinerarioInPendingRepository;
import it.unicam.cs.repository.IPOIInPendingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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


    @PostMapping("/poisInPending")
    public ResponseEntity<Object> inserisciPOIInPending(@RequestBody POI poi){
        this.poiInPendingRepository.save(poi);
        return new ResponseEntity<>("poi inserito in pending", HttpStatus.OK);
    }

    @PostMapping("/pois/{POIId}/eventiInPending")
    public ResponseEntity<Object> inserisciEventoInPending(@PathVariable(value = "POIId") Integer POIId, @RequestBody Evento evento){
        this.eventoInPendingRepository.save(evento);
        return new ResponseEntity<>("evento inserito in pending", HttpStatus.OK);
    }

    @PostMapping("/itinerariInPending")
    public ResponseEntity<Object> inserisciItinerarioInPending(@RequestBody Itinerario itinerario){
        this.itinerarioInPendingRepository.save(itinerario);
        return new ResponseEntity<>("itinerario inserito in pending", HttpStatus.OK);
    }

    @PostMapping("/pois/{POIId}/contenutiIInPenidng")
    public ResponseEntity<Object> inserisciContenutoMultimedialeInPending(@PathVariable(value = "POIId")Integer POIId, @RequestBody ContenutoMultimediale contenutoMultimediale){
        this.contenutoMultimedialeInPendingRepository.save(contenutoMultimediale);
        return new ResponseEntity<>("contenuto inserito in pending", HttpStatus.OK);
    }
}
