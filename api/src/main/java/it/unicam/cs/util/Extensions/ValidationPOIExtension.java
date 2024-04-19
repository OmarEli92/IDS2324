package it.unicam.cs.util.Extensions;

import it.unicam.cs.exception.POI.*;
import it.unicam.cs.exception.UtentePOINotValidException;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.info.Contatti;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.regex.Pattern;
/*
classe che serve per controllare i metodi che possono essere comuni tra le varie classi
che estendono POI
 */
@Component
@AllArgsConstructor
public class ValidationPOIExtension {
    private final UtenteRepository utenteRepository;
    public void isOrariAperturaValido(String orari){
        String pattern = "^([01]?[0-9]|2[0-3]):[0-5][0-9]-([01]?[0-9]|2[0-3]):[0-5][0-9]$";
        boolean match = Pattern.matches(pattern,orari);
        if(!match){
            throw new IllegalArgumentException("formato orario non corretto");
        }
    }
    public void isResponsabileValido (String string){
        if(string != null) {
            if (string.trim().length() < 3 && string.trim().length() > 20) {
                throw new IllegalArgumentException("lunghezza responsabile non corretta");
            }
            Pattern pattern = Pattern.compile("[^a-zA-Z0-9]+");
            boolean valid = pattern.matcher(string).matches();
            if (!valid) {
                throw new IllegalArgumentException("responsabile non può avere caratteri speciali");
            }
        }
    }
    public void areContattiValidi(Contatti contatti){
        Pattern pattern = Pattern.compile("\\+39[ ]?\\d{2}[ ]?\\d{3}[ ]?\\d{4}$");
        Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Pattern pattern2 = Pattern.compile("^\\\\+?[0-9\\\\-\\\\(\\\\) ]{5,20}$");
        boolean valid = pattern.matcher(contatti.getTelefono()).matches() && pattern1.matcher(contatti.getEmail()).matches()
                && pattern2.matcher(contatti.getFax()).matches();
        if(!valid){
            throw new ContattiNonValidiException();
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
    public void isPOIContributoreValid(Integer idContributore) {
        Utente utente = utenteRepository.getReferenceById(idContributore);
        if(!utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE)
                && !utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO)
                && !utente.getRuoli().contains((RuoliUtente.CURATORE))){
            throw new UtentePOINotValidException("l'utente non è autorizzato a caricare il POI");
        }

    }

    public void isPOINomeValid(String nome)  {
        if(nome.isBlank()){
            throw new IllegalArgumentException("il nome non può essere nullo, vuoto e non può " +
                    "contenere solo spazi bianchi ");
        }
        if (nome.trim().length()<3 && nome.trim().length()>20){
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
            if (autore.trim().length() < 3 && autore.trim().length() > 20){
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
            if(architettura.trim().length() < 3 && architettura.trim().length() > 20){
                throw new IllegalArgumentException("lunghezza architettura non corretta");
            }
        }
    }
}
