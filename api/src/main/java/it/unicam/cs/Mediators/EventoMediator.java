package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.service.*;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EventoMediator {
    private UtenteService utenteService;
    private POIService poiService;
    private EventoService eventoService;
    private ComuneService comuneService;
    private ConsultazioneContenutiService consultazioneContenutiService;
    private SalvataggioContenutiService salvataggioContenutiService;

    public void salvaEvento(Evento evento){
        salvataggioContenutiService.salvaEvento(evento);
        poiService.salvaEvento(evento.getPoiAssociato().getId(),evento);
        comuneService.aggiungiEvento(evento.getComuneAssociato().getId(),evento);
        utenteService.aggiungiEvento(evento.getContributore().getId(),evento);
    }
    public void validaEvento(RichiestaValidazioneDto richiestaValidazioneDto){
        Evento evento = consultazioneContenutiService.ottieniEventoDaId(richiestaValidazioneDto.getIdContenuto());
        Utente utente = utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore());
        List<String> nomi = utente.getRuoli()
                .stream()
                .map(Ruolo::getNome)
                .collect(Collectors.toList());
        if(evento==null){
            throw new NullPointerException("evento da validare non esistente");
        }
        else if(nomi.contains(RuoliUtente.CURATORE)
                && evento.getStato().equals(StatoElemento.PENDING)
                && utente.getComuneAssociato().getId().equals(evento.getComuneAssociato().getId())){
            eventoService.validaEvento(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            utenteService.aggiornaListaEvento(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            poiService.aggiornaListaEvento(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            comuneService.aggiornaListaEvento(richiestaValidazioneDto.getIdContenuto() , richiestaValidazioneDto.isValidato());
        }
        else if(!nomi.contains(RuoliUtente.CURATORE)){
            throw new RichiestaValidUtenteNotValidException();
        }
        else if(!utente.getComuneAssociato().getId().equals(evento.getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else{
            throw new RichiestaValidContenutoNotValidException();
        }
    }

    public void apriEvento(Integer idEvento) {
        poiService.aggiornaListaEventiDaAprire(idEvento);
        utenteService.aggiornaListaEventiCreatiDaAprire(idEvento);
        comuneService.aggiornaListaEventiDaAprire(idEvento);
    }

    public void chiudiEvento(Integer idEvento) {
        poiService.aggiornaListaEventiDaChiudere(idEvento);
        utenteService.aggiornaListaEventiCreatiDaChiudere(idEvento);
        comuneService.aggiornaListaEventiDaChiudere(idEvento);
    }
}
