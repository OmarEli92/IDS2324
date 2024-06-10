package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.service.*;
import it.unicam.cs.service.Interfaces.IComuneService;
import it.unicam.cs.service.Interfaces.IItinerarioService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ItinerarioMediator {
    private IComuneService comuneService;
    private IUtenteService utenteService;
    private IItinerarioService itinerarioService;
    private ConsultazioneContenutiService consultazioneContenutiService;

    public void salvaItinerario(Itinerario itinerario){
        itinerarioService.aggiungiItinerario(itinerario);
        comuneService.aggiungiItinerario(itinerario.getComuneAssociato().getId(),itinerario);
        utenteService.aggiungiItinerario(itinerario.getComuneAssociato().getId(),itinerario);
    }
    public void validaItinerario(RichiestaValidazioneDto richiestaValidazioneDto, Integer validatoreId){
        Itinerario itinerario = consultazioneContenutiService.ottieniItinerarioDaId(richiestaValidazioneDto.getIdContenuto());
        Utente utente = utenteService.ottieniUtenteById(validatoreId);
        if(itinerario.getStato().equals(StatoElemento.PENDING)
                && utente.getComuneAssociato().getId().equals(itinerario.getComuneAssociato().getId())){
            utenteService.aggiornaListaItinerario(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            comuneService.aggiornaListaItinerario(richiestaValidazioneDto.getIdContenuto() , richiestaValidazioneDto.isValidato());
            itinerarioService.validaItinerario(richiestaValidazioneDto.getIdContenuto(),richiestaValidazioneDto.isValidato());
        }
        else if(!utente.getComuneAssociato().getId().equals(itinerario.getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else{
            throw new RichiestaValidContenutoNotValidException();
        }
    }
}
