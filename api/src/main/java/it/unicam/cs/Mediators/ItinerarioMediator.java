package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.DTO.RichiestaValidazioneDto;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.service.*;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ItinerarioMediator {
    private ComuneService comuneService;
    private UtenteService utenteService;
    private ItinerarioService itinerarioService;
    private SalvataggioContenutiService salvataggioContenutiService;
    private ConsultazioneContenutiService consultazioneContenutiService;

    public void salvaItinerario(Itinerario itinerario){
        salvataggioContenutiService.salvaItinerario(itinerario);
        comuneService.aggiungiItinerario(itinerario.getComuneAssociato().getId(),itinerario);
        utenteService.aggiungiItinerario(itinerario.getComuneAssociato().getId(),itinerario);
    }
    public void validaItinerario(RichiestaValidazioneDto richiestaValidazioneDto){
        if(consultazioneContenutiService.ottieniItinerarioDaId(richiestaValidazioneDto.getIdContenuto())==null){
            throw new NullPointerException("itinerario da validare non esistente");
        }
        else if(utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getRuoli().contains(RuoliUtente.CURATORE)
                && consultazioneContenutiService.ottieniItinerarioDaId(richiestaValidazioneDto.getIdContenuto()).getStato().equals(StatoElemento.PENDING)
                && utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getComuneAssociato().getId().equals(consultazioneContenutiService.ottieniItinerarioDaId(richiestaValidazioneDto.getIdContenuto()).getComuneAssociato().getId())){
            itinerarioService.validaItinerario(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.getIdUtenteValidatore(),richiestaValidazioneDto.isValidato());
            utenteService.aggiornaListaItinerario(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            comuneService.aggiornaListaItinerario(richiestaValidazioneDto.getIdContenuto() , richiestaValidazioneDto.isValidato());
        }
        else if(!utenteService.ottieniUtenteById((richiestaValidazioneDto.getIdUtenteValidatore())).getRuoli().contains(RuoliUtente.CURATORE)){
            throw new RichiestaValidUtenteNotValidException();
        }
        else if(!utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getComuneAssociato().getId().equals(consultazioneContenutiService.ottieniItinerarioDaId(richiestaValidazioneDto.getIdContenuto()).getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else{
            throw new RichiestaValidContenutoNotValidException();
        }
    }
}
