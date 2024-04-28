package it.unicam.cs.service;

import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IItinerarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ItinerarioService {
    private IItinerarioRepository  itinerarioRepository;

    public void salvaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale, Integer idItinerario){
        Itinerario itinerario = itinerarioRepository.getReferenceById(idItinerario);
        itinerario.aggiungiContenutoMultimediale(contenutoMultimediale);
        itinerarioRepository.save(itinerario);
    }
}
