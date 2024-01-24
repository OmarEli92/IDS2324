package it.unicam.cs.model;

import it.unicam.cs.util.Ruolo;

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
    private final int IDcomuneAssociato;

    public Utente(String nome, String cognome, int id, LocalDate dataDiNascita,
                  String email, String sesso, String telefono,
                  int numeroDiContribuzioni, int IDcomuneAssociato){
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.sesso = sesso;
        this.telefono = telefono;
        this.numeroDiContribuzioni = numeroDiContribuzioni;
        this.IDcomuneAssociato = IDcomuneAssociato;
    }

    public void eliminaContenuto(final int idPoi, final String tipoContenuto){
        //TODO
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

    public void aggiungiContribuzione() {
        numeroDiContribuzioni++;
    }

}
