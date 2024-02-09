package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;

import java.time.LocalDate;

public class Turista extends Utente{
    public Turista(String nome, String cognome, String id, LocalDate dataDiNascita,
                   String email, String sesso, String telefono, int numeroDiContribuzioni, String idComune) {
        super(nome, cognome, id, dataDiNascita, email, sesso, telefono, numeroDiContribuzioni, idComune);
    }


}



