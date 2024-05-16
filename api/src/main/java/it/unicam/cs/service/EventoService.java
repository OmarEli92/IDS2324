package it.unicam.cs.service;

import it.unicam.cs.Mediators.EventoMediator;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EventoService {
    private IEventoRepository eventoRepository;
    private ConsultazioneContenutiService consultazioneContenutiService;
    private EventoMediator eventoMediator;

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
        if(validato){
            evento.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.PUBBLICATO));
            eventoRepository.save(evento);
        }
        else {
            ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
            evento.getContenutiMultimediali().remove(contenutoMultimediale);
            eventoRepository.save(evento);
        }
    }

    public void aggiornaListaContenutoMultimedialeDaSegnalare(Integer id) {
        Evento evento = eventoRepository.findEventoByContenutoMultimedialeId(id);
        evento.getContenutiMultimediali()
                .stream()
                .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(id))
                .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.SEGNALATO));
        eventoRepository.save(evento);
    }

    public void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato) {
        Evento evento = eventoRepository.findEventoByContenutoMultimedialeId(idContenutoMultimediale);
        ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
        if(eliminato){
            evento.getContenutiMultimediali().remove(contenutoMultimediale);
            eventoRepository.save(evento);
        }
        else {
            evento.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale1 -> contenutoMultimediale1.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale1 -> contenutoMultimediale1.setStato(StatoElemento.PUBBLICATO));
            eventoRepository.save(evento);
        }
    }
    public void apriEvento(Evento evento){
        evento.setAperto(true);
        eventoRepository.save(evento);
    }
    @Transactional
    @Scheduled(cron = "0 0 0 0 * *")
    public void verificaAperture(){
        LocalDateTime ora = LocalDateTime.now();
        List<Evento> eventiDaAprire = eventoRepository.findByDataInizioBeforeAndApertoIsFalse(ora);
        eventiDaAprire.forEach(evento -> {apriEvento(evento);
            eventoMediator.apriEvento(evento.getId());});
    }
    public void chiudiEvento(Evento evento){
        eventoRepository.delete(evento);
    }
    public void verificaScadenze(){
        LocalDateTime ora = LocalDateTime.now();
        List<Evento> eventiDaChiudere = eventoRepository.findByDataFineBeforeAndApertoIsTrue(ora);
        eventiDaChiudere.forEach(evento -> {eventoMediator.chiudiEvento(evento.getId());
        chiudiEvento(evento);});
    }
}
