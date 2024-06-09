package it.unicam.cs.util.Extensions;

import it.unicam.cs.exception.Contenuto.*;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.IComuneRepository;
import it.unicam.cs.service.Interfaces.IComuneService;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.service.OSMService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.Match;
import it.unicam.cs.util.info.Contatti;
import it.unicam.cs.util.info.Posizione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.regex.Pattern;

/*
classe che serve per controllare i metodi che possono essere comuni tra le varie classi
che estendono POI
 */
@Component
public class ValidationPOIExtension {
    @Autowired
    private OSMService osmService;
    @Autowired
    private IUtenteService utenteService;

    public void isOrariAperturaValido(String orario){
        if(!orario.isBlank()) {
            boolean match = Match.isOrarioValido(orario);
            if (!match) {
                throw new IllegalArgumentException("formato orario non corretto");
            }
        }
    }
    public void isResponsabileValido (String string){
        if(string != null) {
            if (string.trim().length() < 3 || string.trim().length() > 20) {
                throw new IllegalArgumentException("lunghezza responsabile non corretta");
            }
            boolean match = Match.contieneCaratteriSpeiali(string);
            if (match) {
                throw new IllegalArgumentException("responsabile non può avere caratteri speciali");
            }
        }
    }
    public void areContattiValidi(Contatti contatti){
        if(contatti!=null) {
            boolean match = Match.isNumeroDiTelefono(contatti.getTelefono()) && Match.isEmail(contatti.getEmail())
                        && Match.isFax(contatti.getFax());
            if (!match) {
                throw new ContattiNonValidiException();
            }
        }
    }
    public void isEtaConsigliatiValida(int eta){
        if(eta < 0){
            throw new IllegalArgumentException("l'età deve essere maggiore uguale di 0");
        }
    }
    public void isEstensioneValida(int numero){
        if(numero < 1){
            throw new IllegalArgumentException("il numero dell'estensione deve essere > 0");
        }
    }

    public void isPOINomeValid(String nome)  {
        if(nome.isBlank()){
            throw new IllegalArgumentException("il nome non può essere nullo, vuoto e non può " +
                    "contenere solo spazi bianchi ");
        }
        if (nome.trim().length()<3 || nome.trim().length()>20){
            throw new IllegalArgumentException("lunghezza nome incorretta");
        }
    }
    public void isNumeroSaleValid(int numero){
        if(numero < 1){
            throw new IllegalArgumentException("il numero delle sale deve essere maggiore di 0");
        }
    }
    public void isAnnoRealizzazioneValid(int anno){
        if(anno > LocalDate.now().getYear()){
            throw new IllegalArgumentException("l'anno di realizzazione non può essere " +
                    "magggiore di quella attuale");
        }
    }
    public void isDescrizioneValid(String descrizione){
        if(descrizione!=null){
            if(descrizione.trim().length() < 3){
                throw new IllegalArgumentException("lunghezza descrizione non corretta");
            }
        }
    }
    public void isAutoreValid (String autore){
        if(autore != null){
            if (autore.trim().length() < 3 || autore.trim().length() > 20){
                throw new IllegalArgumentException("lunghezza autore non corretta");
            }
        }
    }
    public void isAltezzaValid(double altezza){
        if(altezza <= 0){
            throw new IllegalArgumentException("altezza deve essere > 0");
        }
    }
    public void isLunghezzaValid(double lunghezza){
        if(lunghezza <= 0){
            throw new IllegalArgumentException("lunghezza deve essere > 0");
        }
    }
    public void isArchitetturaValid(String architettura){
        if(architettura != null){
            if(architettura.trim().length() < 3 || architettura.trim().length() > 20){
                throw new IllegalArgumentException("lunghezza architettura non corretta");
            }
        }
    }
    public void isPOIInComune(PoiDto poiDto){
        Utente utente = utenteService.ottieniUtente(poiDto.getIdContributore());
        Comune comune = utente.getComuneAssociato();
        boolean inside = osmService.verificaPuntoNelComune(poiDto.getPosizione(), (Posizione[]) comune.getPerimetro().toArray());
        if(!inside){
            throw new PosizionePOINotValidException();
        }
    }
}
