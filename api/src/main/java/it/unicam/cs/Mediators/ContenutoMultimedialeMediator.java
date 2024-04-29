package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.DTO.RichiestaValidazioneDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.*;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ContenutoMultimedialeMediator {
    private UtenteService utenteService;
    private EventoService eventoService;
    private ComuneService comuneService;
    private ContenutoMultimedialeService contenutoMultimedialeService;
    private POIService poiService;
    private ItinerarioService itinerarioService;
    private ConsultazioneContenutiService consultazioneContenutiService;
    private SalvataggioContenutiService salvataggioContenutiService;

    public void salvaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        salvataggioContenutiService.salvaContenutoMultimediale(contenutoMultimediale);
        if(contenutoMultimediale.getEventoAssociato()!=null){
            eventoService.salvaContenutoMultimediale(contenutoMultimediale.getEventoAssociato().getId(),contenutoMultimediale);
            comuneService.aggiungiContenutoMultimediale(contenutoMultimediale.getEventoAssociato().getComuneAssociato().getId(),contenutoMultimediale);
        }
        else if(contenutoMultimediale.getPoiAssociato()!=null){
            poiService.salvaContenutoMultimediale(contenutoMultimediale.getPoiAssociato().getId(),contenutoMultimediale);
            comuneService.aggiungiContenutoMultimediale(contenutoMultimediale.getPoiAssociato().getComuneAssociato().getId(),contenutoMultimediale);
        }
        else{
            itinerarioService.salvaContenutoMultimediale(contenutoMultimediale, contenutoMultimediale.getItinerarioAssociato().getId());
            comuneService.aggiungiContenutoMultimediale(contenutoMultimediale.getItinerarioAssociato().getComuneAssociato().getId(),contenutoMultimediale);
        }
        utenteService.aggiungiContenutoMultimediale(contenutoMultimediale.getUtenteCreatore().getId(),contenutoMultimediale);
    }
    public void validaContenuto(RichiestaValidazioneDto richiestaValidazioneDto){
        if(consultazioneContenutiService.ottieniContenutoMultimedialeDaId(richiestaValidazioneDto.getIdContenuto())==null){
            throw new NullPointerException("contenuto multimediale da validare non esistente");
        }
        else if(!utenteService.ottieniUtenteById((richiestaValidazioneDto.getIdUtenteValidatore())).getRuoli().contains(RuoliUtente.CURATORE)){
            throw new RichiestaValidUtenteNotValidException();
        }
        else if(!utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getComuneAssociato().getId().equals(consultazioneContenutiService.ottieniContenutoMultimedialeDaId(richiestaValidazioneDto.getIdContenuto()).getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else if(!consultazioneContenutiService.ottieniContenutoMultimedialeDaId(richiestaValidazioneDto.getIdContenuto()).getStato().equals(StatoElemento.PUBBLICATO)){
            throw new RichiestaValidContenutoNotValidException();
        }
        else if(utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getRuoli().contains(RuoliUtente.CURATORE)
                && consultazioneContenutiService.ottieniContenutoMultimedialeDaId(richiestaValidazioneDto.getIdContenuto()).getStato().equals(StatoElemento.PENDING)
                && utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getComuneAssociato().getId().equals(consultazioneContenutiService.ottieniContenutoMultimedialeDaId(richiestaValidazioneDto.getIdContenuto()).getPoiAssociato().getComuneAssociato().getId())){
            contenutoMultimedialeService.validaContenutoMultimediale(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            utenteService.aggiornaListaContenutiMultimediali(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
        }
        if(consultazioneContenutiService.ottieniContenutoMultimedialeDaId(richiestaValidazioneDto.getIdContenuto()).getPoiAssociato()!=null){
            poiService.aggiornaListaContenutoMultimediale(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
        }
        else if(consultazioneContenutiService.ottieniContenutoMultimedialeDaId(richiestaValidazioneDto.getIdContenuto()).getItinerarioAssociato()!=null){
            itinerarioService.aggiornaListaContenutoMultimediale(richiestaValidazioneDto.getIdContenuto() ,richiestaValidazioneDto.isValidato());
        }
        else if(consultazioneContenutiService.ottieniContenutoMultimedialeDaId(richiestaValidazioneDto.getIdContenuto()).getEventoAssociato()!=null){
            eventoService.aggiornaListaContenutoMultimediale(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
        }
    }
}
