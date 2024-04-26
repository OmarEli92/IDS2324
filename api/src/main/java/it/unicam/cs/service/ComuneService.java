package it.unicam.cs.service;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IComuneRepository;
import it.unicam.cs.repository.UtenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ComuneService {
    @Autowired
    private IComuneRepository comuneRepository;

    public void aggiungiPOI(Integer idComune, POI poi){
        Comune comune = comuneRepository.getReferenceById(idComune);
        comune.aggiungiPOI(poi);
        comuneRepository.save(comune);
    }
    public void aggiungiItinerario(Integer idComune, Itinerario itinerario){
        Comune comune = comuneRepository.getReferenceById(idComune);
        comune.aggiugniItinerario(itinerario);
        comuneRepository.save(comune);
    }
}
