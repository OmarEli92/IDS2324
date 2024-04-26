package it.unicam.cs.service;

import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IPOIRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class POIService {
    private IPOIRepository poiRepository;

    public void salvaContenutoMultimediale(Integer idPoi, ContenutoMultimediale contenutoMultimediale){
        POI poi = poiRepository.getReferenceById(idPoi);
        poi.aggiungiContenutoMultimediale(contenutoMultimediale);
        poiRepository.save(poi);
    }
    public void salvaEvento(Integer idPoi, Evento evento){
        POI poi = poiRepository.getReferenceById(idPoi);
        poi.aggiungiEvento(evento);
        poiRepository.save(poi);
    }
}
