package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;

import java.time.LocalDate;

public class Turista extends Utente{
    public Turista(String nome, String cognome, Integer id, LocalDate dataDiNascita,
                   String email, String sesso, String telefono, int numeroDiContribuzioni, Comune comuneAssociato) {
        super(id,nome, cognome, dataDiNascita, email, sesso, telefono, numeroDiContribuzioni, comuneAssociato);
    }


}



