package it.unicam.cs.util.Extensions;

import it.unicam.cs.exception.Contenuto.POINotFoundException;
import it.unicam.cs.exception.Contenuto.POINotValidException;
import it.unicam.cs.exception.UtenteNotValidException;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.Match;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class ValidationEventoExtension {
    @Autowired
    private UtenteService utenteService;

    public void isNomeValid(String nome){
        if(nome.isBlank()){
            throw new IllegalArgumentException("il nome non può essere nullo, vuoto e non può " +
                    "contenere solo spazi bianchi ");
        }
        if (nome.trim().length()<3 || nome.trim().length()>20){
            throw new IllegalArgumentException("lunghezza nome incorretta");
        }
    }
    @Transactional
    public void isIdPoiEventovalid(Integer idUtente,Integer idPOI){
        if(idPOI == null){
            throw new NullPointerException("id poi non deve essere nullo");
        }
        Utente utente = utenteService.ottieniUtenteById(idUtente);
        Comune comune = utente.getComuneAssociato();
        List<POI> pois = comune.getPOIS().stream()
                .filter(poi -> poi.getStato().equals(StatoElemento.PUBBLICATO))
                .collect(Collectors.toList());
        if(!pois.stream()
                .map(POI::getId)
                .collect(Collectors.toList())
                .contains(idPOI)){
            throw new POINotValidException();
        }
    }

    public void isDescrizioneValid(String descrizione){
        if(descrizione!=null){
            if(descrizione.trim().length() < 3){
                throw new IllegalArgumentException("lunghezza descrizione non corretta");
            }
        }
    }
    public void isResponsabileValido (String responsabile){
        if(responsabile != null) {
            if (responsabile.trim().length() < 3 || responsabile.trim().length() > 20) {
                throw new IllegalArgumentException("lunghezza responsabile non corretta");
            }
            boolean match  = Match.contieneCaratteriSpeiali(responsabile);
            if (match) {
                throw new IllegalArgumentException("responsabile non può avere caratteri speciali");
            }
        }
    }
    public void isEtaConsigliatiValida(int eta){
        if(eta < 0){
            throw new IllegalArgumentException("l'età deve essere maggiore uguale di 0");
        }
    }
    public void verificaDateEvento(LocalDateTime dataInizio, LocalDateTime dataFine) {
        if(dataInizio == null || dataFine == null){
            throw new NullPointerException("data di inizio e fine non possono essere nulle");
        }
        if(LocalDateTime.now().isAfter(dataInizio) || LocalDateTime.now().isAfter(dataFine) ||
                dataFine.isBefore(dataInizio)){
            throw new IllegalArgumentException("le date di inizio e fine non possono essere " +
                    "prima di quella di oggi, e la data di inizio deve anticipare la data di fine");
        }
    }

}
