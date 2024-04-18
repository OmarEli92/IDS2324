package it.unicam.cs.util.Extensions;

import it.unicam.cs.exception.POI.ContattiNonValidiException;
import it.unicam.cs.exception.POI.OrariAperturaNotValidException;
import it.unicam.cs.exception.POI.ResponsabilePOINotValidException;
import it.unicam.cs.util.info.Contatti;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidationPOIExtension {
    public void isOrariAperturaValido(String orari){
        String pattern = "^([01]?[0-9]|2[0-3]):[0-5][0-9]-([01]?[0-9]|2[0-3]):[0-5][0-9]$";
        boolean match = Pattern.matches(pattern,orari);
        if(!match){
            throw new OrariAperturaNotValidException("formato non valido, deve essere di tipo xx:xx " +
                    " -xx::xx dove xx rappresenta un orario (nel caso di orari con una sola cifra, " +
                    " scriverci davanti uno 0");
        }
    }
    public void isResponsabileValido (String string){
        if(string.length() < 3 && string.length() > 20){
            throw new ResponsabilePOINotValidException("il responsabile deve " +
                    "avere almeno 3 carratteri e al massimo 20");
        }
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]+");
        boolean valid = pattern.matcher(string).matches();
        if(!valid){
            throw new ResponsabilePOINotValidException("il resposnabile non può contenere " +
                    "caratteri speciali");
        }
    }
    public void areContattiValidi(Contatti contatti){
        Pattern pattern = Pattern.compile("\\+39[ ]?\\d{2}[ ]?\\d{3}[ ]?\\d{4}$");
        Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Pattern pattern2 = Pattern.compile("^\\\\+?[0-9\\\\-\\\\(\\\\) ]{5,20}$");
        boolean valid = pattern.matcher(contatti.getTelefono()).matches() && pattern1.matcher(contatti.getEmail()).matches()
                && pattern2.matcher(contatti.getFax()).matches();
        if(!valid){
            throw new ContattiNonValidiException("contatti inseriti non validi");
        }
    }
}
