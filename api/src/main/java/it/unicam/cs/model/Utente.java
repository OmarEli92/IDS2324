package it.unicam.cs.model;

import java.time.LocalDate;


/** La classe astratta Utente definisce le informazioni comuni che sono condivise
 *  tra i diversi tipi di utente che sono registrati sulla piattaforma e i metodi principali **/
public abstract class Utente {
    private final String nome;
    private final String cognome;
    private final int id;
    private final LocalDate dataDiNascita;
    private String email;
    private final String sesso;
    private String telefono;
    private int numeroDiContribuzioni;

    public Utente(String nome, String cognome, int id, LocalDate dataDiNascita, String email, String sesso, String telefono, int numeroDiContribuzioni) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.sesso = sesso;
        this.telefono = telefono;
        this.numeroDiContribuzioni = numeroDiContribuzioni;
    }
        /* Metodi Get*/
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public String getEmail() {
        return email;
    }

    public String getSesso() {
        return sesso;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getNumeroDiContribuzioni() {
        return numeroDiContribuzioni;
    }

    public void aggiungiContribuzione(){
        numeroDiContribuzioni++;
    }

/** Metodo che permette di aggiungere un POI alla piattaforma **/
    public abstract void creaPOI();

    /** Metodo che permette di aggiungere un itinerario alla piattaforma **/
    public abstract void creaItinerario();
}
