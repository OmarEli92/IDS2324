package it.unicam.cs.model;

public enum Ruolo {
    CONTRIBUTORE("contributore"),
    CONTRIBUTORE_AUTORIZZATO("contributore autorizzato");

    private final String ruolo;
    Ruolo(String ruolo){
        this.ruolo = ruolo;
    }



}
