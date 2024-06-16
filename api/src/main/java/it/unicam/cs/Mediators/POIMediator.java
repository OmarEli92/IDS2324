package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.proxy.ProxyService;
import it.unicam.cs.service.*;
import it.unicam.cs.service.Interfaces.IComuneService;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.service.Interfaces.IPOIService;
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
public class POIMediator {
    private IComuneService comuneService;
    private IUtenteService utenteService;
    private IPOIService poiService;
    private IConsultazioneContenutiService consultazioneContenutiService;
    private ProxyService proxyService;

    public void salvaPOI(POI poi){
        poiService.aggiungiPOI(poi);
        comuneService.aggiungiPOI(poi.getComuneAssociato().getId(),poi);
        utenteService.aggiungiPOI(poi.getContributore().getId(),poi);
        proxyService.invalidaComuneNellaCache(poi.getComuneAssociato().getNome());
    }
    public void validaPOI(RichiestaValidazioneDto richiestaValidazioneDto, Integer validatoreId){
        POI poi = consultazioneContenutiService.ottieniPOIdaId(richiestaValidazioneDto.getIdContenuto());
        Utente utente = utenteService.ottieniUtenteById(validatoreId);
        if (poi.getStato().equals(StatoElemento.PENDING)
        && utente.getComuneAssociato().getId().equals(poi.getComuneAssociato().getId())){
            utenteService.aggiornaListaPOI(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            comuneService.aggiornaListaPOI(richiestaValidazioneDto.getIdContenuto() ,richiestaValidazioneDto.isValidato());
            poiService.validaPOI(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
        }
        else if(!utente.getComuneAssociato().getId().equals(poi.getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else{
            throw new RichiestaValidContenutoNotValidException();
        }
    }
}
