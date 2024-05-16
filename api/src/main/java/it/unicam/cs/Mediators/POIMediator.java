package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
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
        POI poi = consultazioneContenutiService.ottieniPOIdaId(richiestaValidazioneDto.getIdContenuto());
        Utente utente = utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore());
        List<String> nomi = utente.getRuoli()
                .stream()
                .map(Ruolo::getNome)
                .collect(Collectors.toList());
        if(poi==null){
            throw new NullPointerException("poi da validare non esistente");
        }
        else if(nomi.contains(RuoliUtente.CURATORE.name())
        && poi.getStato().equals(StatoElemento.PENDING)
        && utente.getComuneAssociato().getId().equals(poi.getComuneAssociato().getId())){
            poiService.validaPOI(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            utenteService.aggiornaListaPOI(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            comuneService.aggiornaListaPOI(richiestaValidazioneDto.getIdContenuto() ,richiestaValidazioneDto.isValidato());
        }
        else if(!nomi.contains(RuoliUtente.CURATORE.name())){
            throw new RichiestaValidUtenteNotValidException();
        }
        else if(!utente.getComuneAssociato().getId().equals(poi.getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else{
            throw new RichiestaValidContenutoNotValidException();
        }
    }
}
