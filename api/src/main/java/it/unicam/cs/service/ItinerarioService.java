package it.unicam.cs.service;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
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
    private ConsultazioneContenutiService consultazioneContenutiService;

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
    public void aggiornaListaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato){
        Itinerario itinerario = itinerarioRepository.findItinerarioByContenutoMultimedialeId(idContenutoMultimediale);
        Utente utente = utenteRepository.findByContenutoMultimedialeId(idContenutoMultimediale);
        if(validato){
            itinerario.getContenutiMultimedialiAssociati()
                    .stream()
                    .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(utente));
            itinerarioRepository.save(itinerario);
        }
        else {
            ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
            itinerario.getContenutiMultimedialiAssociati().remove(contenutoMultimediale);
            itinerarioRepository.save(itinerario);
        }
    }
}
