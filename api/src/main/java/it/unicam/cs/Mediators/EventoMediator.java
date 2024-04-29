package it.unicam.cs.Mediators;

import it.unicam.cs.model.DTO.RichiestaValidazioneDto;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.service.*;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        utenteService.aggiungiEvento(evento.getContributore().getId(),evento);
    }
    public void validaEvento(RichiestaValidazioneDto richiestaValidazioneDto){
        if(consultazioneContenutiService.ottieniEventoDaId(richiestaValidazioneDto.getIdContenuto())==null){
            throw new NullPointerException("evento da validare non esistente");
        }
        else if(utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getRuoli().contains(RuoliUtente.CURATORE)
                && consultazioneContenutiService.ottieniEventoDaId(richiestaValidazioneDto.getIdContenuto()).getStato().equals(StatoElemento.PENDING)
                && utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getComuneAssociato().getId().equals(consultazioneContenutiService.ottieniEventoDaId(richiestaValidazioneDto.getIdContenuto()).getComuneAssociato().getId())){
            eventoService.validaEvento(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            utenteService.aggiornaListaEvento(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            poiService.aggiornaListaEvento(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            comuneService.aggiornaListaEvento(richiestaValidazioneDto.getIdContenuto() , richiestaValidazioneDto.isValidato());
        }
    }
}
