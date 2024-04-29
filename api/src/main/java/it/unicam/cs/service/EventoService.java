package it.unicam.cs.service;

import it.unicam.cs.model.DTO.RichiestaValidazioneDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.util.enums.StatoElemento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EventoService {
    private IEventoRepository eventoRepository;
    private UtenteRepository utenteRepository;
    private ConsultazioneContenutiService consultazioneContenutiService;

    public void salvaContenutoMultimediale(Integer idEvento, ContenutoMultimediale contenutoMultimediale){
        Evento evento = eventoRepository.getReferenceById(idEvento);
        evento.aggiungiContenutoMultimediale(contenutoMultimediale);
        eventoRepository.save(evento);
    }
    public void validaEvento(Integer idEvento, boolean validato){
        Evento evento = eventoRepository.getReferenceById(idEvento);
        if(validato){
            evento.setStato(StatoElemento.PUBBLICATO);
            eventoRepository.save(evento);
        }
        else {
            eventoRepository.deleteById(idEvento);
        }
    }
    public void aggiornaListaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato){
        Evento evento = eventoRepository.findEventoByContenutoMultimedialeId(idContenutoMultimediale);
        Utente utente = utenteRepository.findByContenutoMultimedialeId(idContenutoMultimediale);
        if(validato){
            evento.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(utente));
            eventoRepository.save(evento);
        }
        else {
            ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
            evento.getContenutiMultimediali().remove(contenutoMultimediale);
            eventoRepository.save(evento);
        }
    }
}
