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
}
