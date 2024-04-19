package it.unicam.cs.util.Extensions;

import it.unicam.cs.exception.POI.*;
import it.unicam.cs.exception.UtentePOINotValidException;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.info.Contatti;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@AllArgsConstructor
public class ValidationPOIExtension {
    private final UtenteRepository utenteRepository;
    public void isOrariAperturaValido(String orari){
        String pattern = "^([01]?[0-9]|2[0-3]):[0-5][0-9]-([01]?[0-9]|2[0-3]):[0-5][0-9]$";
        boolean match = Pattern.matches(pattern,orari);
        if(!match){
            throw new OrariAperturaNotValidException();
        }
    }
    public void isResponsabileValido (String string){
        if(string.length() < 3 && string.length() > 20){
            throw new ResponsabilePOINotValidException();
        }
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]+");
        boolean valid = pattern.matcher(string).matches();
        if(!valid){
            throw new ResponsabilePOINotValidException();
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
            throw new EtaConsigliataNonValidaException();
        }
    }
    public void isEstensioneValida(int numero){
        if(numero < 0){
            throw new EstensioneNotValidException();
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
        if (nome.length()<3 && nome.length()>20){
            throw new NamePOINotValidException();
        }
        if(nome.isBlank()){
            throw new NamePOINotValidException();
        }
    }
    public void isNumeroSaleValid(int numero){
        if(numero < 1){
            throw new NumeroSaleNotValidException();
        }
    }
}
