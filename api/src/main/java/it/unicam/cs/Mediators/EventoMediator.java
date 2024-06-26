package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.proxy.ProxyService;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.service.*;
import it.unicam.cs.service.Interfaces.*;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EventoMediator {
    private IUtenteService utenteService;
    private IPOIService poiService;
    private IEventoService eventoService;
    private IEventoRepository eventoRepository;
    private IComuneService comuneService;
    private IConsultazioneContenutiService consultazioneContenutiService;
    private ProxyService proxyService;
    public void salvaEvento(Evento evento){
        eventoService.aggiungiEvento(evento);
        poiService.salvaEvento(evento.getPoiAssociato().getId(),evento);
        comuneService.aggiungiEvento(evento.getComuneAssociato().getId(),evento);
        utenteService.aggiungiEvento(evento.getContributore().getId(),evento);
        proxyService.invalidaComuneNellaCache(evento.getComuneAssociato().getNome());
    }
    public void validaEvento(RichiestaValidazioneDto richiestaValidazioneDto, Integer userId){
        Evento evento = consultazioneContenutiService.ottieniEventoDaId(richiestaValidazioneDto.getIdContenuto());
        Utente utente = utenteService.ottieniUtenteById(userId);
        if(evento.getStato().equals(StatoElemento.PENDING)
                && utente.getComuneAssociato().getId().equals(evento.getComuneAssociato().getId())){
            utenteService.aggiornaListaEvento(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            poiService.aggiornaListaEvento(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            comuneService.aggiornaListaEvento(richiestaValidazioneDto.getIdContenuto() , richiestaValidazioneDto.isValidato());
            eventoService.validaEvento(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
        }
        else if(!utente.getComuneAssociato().getId().equals(evento.getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else{
            throw new RichiestaValidContenutoNotValidException();
        }
    }

    @Transactional
    @Scheduled(cron = "0 0 0 0 * *")
    public void verificaAperture(){
        LocalDateTime ora = LocalDateTime.now();
        List<Evento> eventiDaAprire = eventoRepository.findByDataInizioBeforeAndApertoIsFalse(ora);
        eventiDaAprire.forEach(evento -> {eventoService.apriEvento(evento);
            poiService.aggiornaListaEventiDaAprire(evento.getId());
            utenteService.aggiornaListaEventiCreatiDaAprire(evento.getId());
            comuneService.aggiornaListaEventiDaAprire(evento.getId());});
    }
    @Transactional
    @Scheduled(cron = "0 0 0 0 * *")
    public void verificaScadenze(){
        LocalDateTime ora = LocalDateTime.now();
        List<Evento> eventiDaChiudere = eventoRepository.findByDataFineBeforeAndApertoIsTrue(ora);
        eventiDaChiudere.forEach(evento -> {eventoService.chiudiEvento(evento);
            poiService.aggiornaListaEventiDaChiudere(evento.getId());
            utenteService.aggiornaListaEventiCreatiDaChiudere(evento.getId());
            comuneService.aggiornaListaEventiDaChiudere(evento.getId());});
    }

}
