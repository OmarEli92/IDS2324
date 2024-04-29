package it.unicam.cs.service;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.util.enums.StatoElemento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ItinerarioService {
    private IItinerarioRepository  itinerarioRepository;
    private UtenteRepository utenteRepository;

    public void salvaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale, Integer idItinerario){
        Itinerario itinerario = itinerarioRepository.getReferenceById(idItinerario);
        itinerario.aggiungiContenutoMultimediale(contenutoMultimediale);
        itinerarioRepository.save(itinerario);
    }
    public void validaItinerario(Integer idItinerario, boolean validato){
        Itinerario itinerario = itinerarioRepository.getReferenceById(idItinerario);
        Utente utente = utenteRepository.findByIitinerarioId(idItinerario);
        if(validato){
            itinerario.setStato(utente);
            itinerarioRepository.save(itinerario);
        }
        else {
            itinerarioRepository.deleteById(idItinerario);
        }
    }
}
