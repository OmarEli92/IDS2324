package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaSegnalazione.ContenutoMultimedialeDaSegnalareException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.model.DTO.input.EliminazioneContenutoDto;
import it.unicam.cs.model.DTO.input.RichiestaSegnalazioneDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.service.*;
import it.unicam.cs.service.Interfaces.*;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ContenutoMultimedialeMediator {
    private IUtenteService utenteService;
    private IEventoService eventoService;
    private IComuneService comuneService;
    private IContenutoMultimedialeService contenutoMultimedialeService;
    private IPOIService poiService;
    private IItinerarioService itinerarioService;
    private IConsultazioneContenutiService consultazioneContenutiService;
    public void salvaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        contenutoMultimedialeService.aggiungiContenutoMultimediale(contenutoMultimediale);
        if(contenutoMultimediale.getEventoAssociato()!=null){
            eventoService.salvaContenutoMultimediale(contenutoMultimediale.getEventoAssociato().getId(),contenutoMultimediale);
        }
        else if(contenutoMultimediale.getPoiAssociato()!=null){
            poiService.salvaContenutoMultimediale(contenutoMultimediale.getPoiAssociato().getId(),contenutoMultimediale);
        }
        else{
            itinerarioService.salvaContenutoMultimediale(contenutoMultimediale, contenutoMultimediale.getItinerarioAssociato().getId());
        }
        utenteService.aggiungiContenutoMultimediale(contenutoMultimediale.getUtenteCreatore().getId(),contenutoMultimediale);
        comuneService.aggiungiContenutoMultimediale(contenutoMultimediale.getComuneAssociato().getId(),contenutoMultimediale);
    }
    @Transactional
    public void validaContenuto(RichiestaValidazioneDto richiestaValidazioneDto, Integer validatoreId){
        ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(richiestaValidazioneDto.getIdContenuto());
        Utente utente = utenteService.ottieniUtenteById(validatoreId);
        if(!utente.getComuneAssociato().getId().equals(contenutoMultimediale.getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else if(contenutoMultimediale.getStato().equals(StatoElemento.PUBBLICATO)){
            throw new RichiestaValidContenutoNotValidException();
        }
        else if(contenutoMultimediale.getStato().equals(StatoElemento.PENDING)
                && utente.getComuneAssociato().getId().equals(contenutoMultimediale.getPoiAssociato().getComuneAssociato().getId())){
            comuneService.aggiornaListaContenutiMultimediali(richiestaValidazioneDto.getIdContenuto(),richiestaValidazioneDto.isValidato());
            utenteService.aggiornaListaContenutiMultimediali(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
        }
        if(contenutoMultimediale.getPoiAssociato()!=null){
            poiService.aggiornaListaContenutoMultimediale(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
        }
        else if(contenutoMultimediale.getItinerarioAssociato()!=null){
            itinerarioService.aggiornaListaContenutoMultimediale(richiestaValidazioneDto.getIdContenuto() ,richiestaValidazioneDto.isValidato());
        }
        else if(contenutoMultimediale.getEventoAssociato()!=null){
            eventoService.aggiornaListaContenutoMultimediale(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
        }
        contenutoMultimedialeService.validaContenutoMultimediale(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
    }

    @Transactional
    public void segnalaContenutoMultimediale(RichiestaSegnalazioneDto richiestaSegnalazioneDto) {
        ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(richiestaSegnalazioneDto.getIdContenuto());
        if(contenutoMultimediale.getStato().equals(StatoElemento.PUBBLICATO)){
            contenutoMultimedialeService.segnalaContenuto(contenutoMultimediale);
            utenteService.aggiornaListaContenutiMultimedialiSegnalati(contenutoMultimediale.getId());
            comuneService.aggiornaListaContenutiMultimedialiSegnalati(contenutoMultimediale.getId());
            if(contenutoMultimediale.getPoiAssociato()!=null){
                poiService.aggiornaListaContenutoMultimedialeDaSegnalare(contenutoMultimediale.getId());
            }
            else if(contenutoMultimediale.getEventoAssociato()!=null){
                eventoService.aggiornaListaContenutoMultimedialeDaSegnalare(contenutoMultimediale.getId());
            }
            else {
                itinerarioService.aggiornaListaContenutoMultimedialeDaSegnalare(contenutoMultimediale.getId());
            }
        }
        else {
            throw new ContenutoMultimedialeDaSegnalareException();
        }
    }

    public void accettaSegnalazioneContenuto(EliminazioneContenutoDto eliminazioneContenutoDto, Integer userId) {
        Utente utente = utenteService.ottieniUtenteById(userId);
        ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(eliminazioneContenutoDto.getIdContenutoMultimediale());
        if(contenutoMultimediale.getStato().equals(StatoElemento.SEGNALATO)
        && contenutoMultimediale.getComuneAssociato().getId().equals(utente.getComuneAssociato().getId())){
            utenteService.accettaSegnalazioneContenuto(contenutoMultimediale.getId(), eliminazioneContenutoDto.isEliminato());
            comuneService.accettaSegnalazioneContenuto(eliminazioneContenutoDto.getIdContenutoMultimediale(),eliminazioneContenutoDto.isEliminato());
        }
        if(contenutoMultimediale.getPoiAssociato()!=null){
            poiService.accettaSegnalazioneContenuto(eliminazioneContenutoDto.getIdContenutoMultimediale(), eliminazioneContenutoDto.isEliminato());
        }
        else if(contenutoMultimediale.getEventoAssociato()!=null){
            eventoService.accettaSegnalazioneContenuto(eliminazioneContenutoDto.getIdContenutoMultimediale(),eliminazioneContenutoDto.isEliminato());
        }
        else {
            itinerarioService.accettaSegnalazioneContenuto(eliminazioneContenutoDto.getIdContenutoMultimediale(),eliminazioneContenutoDto.isEliminato());
        }
        contenutoMultimedialeService.accettaSegnalazioneContenuto(contenutoMultimediale,eliminazioneContenutoDto.isEliminato());
    }
}
