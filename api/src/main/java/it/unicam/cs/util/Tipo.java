package it.unicam.cs.util;

public enum Tipo {
    Turistico ("Turistico"),
    Amministrativo ("Amministrativo"),
    Intrattenimento ("Intrattenimento");

    private final String codice;

    Tipo (String codice){
        this.codice=codice;
    }



}
