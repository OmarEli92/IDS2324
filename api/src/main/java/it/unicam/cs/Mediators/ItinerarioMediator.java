package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.Itinerario;
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
        Itinerario itinerario = consultazioneContenutiService.ottieniItinerarioDaId(richiestaValidazioneDto.getIdContenuto());
        Utente utente = utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore());
        List<String> nomi = utente.getRuoli()
                .stream()
                .map(Ruolo::getNome)
                .collect(Collectors.toList());
        if(itinerario==null){
            throw new NullPointerException("itinerario da validare non esistente");
        }
        else if(nomi.contains(RuoliUtente.CURATORE.name())
                && itinerario.getStato().equals(StatoElemento.PENDING)
                && utente.getComuneAssociato().getId().equals(itinerario.getComuneAssociato().getId())){
            itinerarioService.validaItinerario(richiestaValidazioneDto.getIdContenuto(),richiestaValidazioneDto.isValidato());
            utenteService.aggiornaListaItinerario(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            comuneService.aggiornaListaItinerario(richiestaValidazioneDto.getIdContenuto() , richiestaValidazioneDto.isValidato());
        }
        else if(!nomi.contains(RuoliUtente.CURATORE.name())){
            throw new RichiestaValidUtenteNotValidException();
        }
        else if(!utente.getComuneAssociato().getId().equals(itinerario.getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else{
            throw new RichiestaValidContenutoNotValidException();
        }
    }
}
