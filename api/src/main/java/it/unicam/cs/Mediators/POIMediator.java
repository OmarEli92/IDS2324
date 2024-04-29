package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.DTO.RichiestaValidazioneDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.service.*;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class POIMediator {
    private ComuneService comuneService;
    private UtenteService utenteService;
    private POIService poiService;
    private SalvataggioContenutiService salvataggioContenutiService;
    private ConsultazioneContenutiService consultazioneContenutiService;

    public void salvaPOI(POI poi){
        salvataggioContenutiService.salvaPOI(poi);
        comuneService.aggiungiPOI(poi.getComuneAssociato().getId(),poi);
        utenteService.aggiungiPOI(poi.getContributore().getId(),poi);
    }
    public void validaPOI(RichiestaValidazioneDto richiestaValidazioneDto){
        if(consultazioneContenutiService.ottieniPOIdaId(richiestaValidazioneDto.getIdContenuto())==null){
            throw new NullPointerException("poi da validare non esistente");
        }
        else if(utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getRuoli().contains(RuoliUtente.CURATORE)
        && consultazioneContenutiService.ottieniPOIdaId(richiestaValidazioneDto.getIdContenuto()).getStato().equals(StatoElemento.PENDING)
        && utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getComuneAssociato().getId().equals(consultazioneContenutiService.ottieniPOIdaId(richiestaValidazioneDto.getIdContenuto()).getComuneAssociato().getId())){
            poiService.validaPOI(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            utenteService.aggiornaListaPOI(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            comuneService.aggiornaListaPOI(richiestaValidazioneDto.getIdContenuto() ,richiestaValidazioneDto.isValidato());
        }
        else if(!utenteService.ottieniUtenteById((richiestaValidazioneDto.getIdUtenteValidatore())).getRuoli().contains(RuoliUtente.CURATORE)){
            throw new RichiestaValidUtenteNotValidException();
        }
        else if(!utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getComuneAssociato().getId().equals(consultazioneContenutiService.ottieniPOIdaId(richiestaValidazioneDto.getIdContenuto()).getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else{
            throw new RichiestaValidContenutoNotValidException();
        }
    }
}
