package it.unicam.cs.model;

import it.unicam.cs.util.Ruolo;

import java.time.LocalDate;

public class TuristaAutenticato extends Utente{
    public TuristaAutenticato(String nome, String cognome, int id, LocalDate dataDiNascita, String email, String sesso, String telefono, int numeroDiContribuzioni, int IDcomuneAssociato) {
        super(nome, cognome, id, dataDiNascita, email, sesso, telefono, numeroDiContribuzioni, IDcomuneAssociato);
    }
}
