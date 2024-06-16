package it.unicam.cs.util;

import java.util.regex.Pattern;

public class Match {
    public static boolean contieneSoloLettere(String stringa){
        Pattern pattern = Pattern.compile("^[A-Za-z][a-z]*(\\s[A-Za-z][a-z]*)*([-'\\s][A-Za-z][a-z]*)*$");
        return pattern.matcher(stringa).matches();
    }
    public static boolean isNumeroDiTelefono(String numeroTelefono){
        Pattern pattern = Pattern.compile("\\+39[ ]?3\\d{2}[ ]?\\d{2}[ ]?\\d{2}[ ]?\\d{3}$");
        return pattern.matcher(numeroTelefono).matches();
    }
    public static boolean isEmail(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        return pattern.matcher(email).matches();
    }
    public static boolean isFax(String fax){
        Pattern pattern = Pattern.compile("^\\\\+?[0-9\\\\-\\\\(\\\\) ]{5,20}$");
        return pattern.matcher(fax).matches();
    }
    public static boolean isOrarioValido(String orario){
        Pattern pattern = Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]-([01]?[0-9]|2[0-3]):[0-5][0-9]$");
        return pattern.matcher(orario).matches();
    }
    public static boolean contieneCaratteriSpeiali(String string){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9 ]+");
        return pattern.matcher(string).matches();
    }
    public static boolean isLink(String link){
        Pattern pattern = Pattern.compile("^(http(s)?://)?([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}(/[a-zA-Z0-9-_.~%]+)*(/\\?[a-zA-Z0-9-_.~&=]+)?$");
        return pattern.matcher(link).matches();
    }
    public static boolean isSesso(String sesso){
        return sesso.equalsIgnoreCase("maschio") || sesso.equalsIgnoreCase("femmina");
    }
    public static boolean isPassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        return pattern.matcher(password).matches();
    }
}
