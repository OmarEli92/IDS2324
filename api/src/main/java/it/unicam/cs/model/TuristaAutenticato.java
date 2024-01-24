package it.unicam.cs.model;


public class TuristaAutenticato {
=======
import java.time.LocalDate;

public class TuristaAutenticato extends Utente{
    public TuristaAutenticato(String nome, String cognome, int id, LocalDate dataDiNascita, String email, String sesso, String telefono, int numeroDiContribuzioni, int IDcomuneAssociato) {
        super(nome, cognome, id, dataDiNascita, email, sesso, telefono, numeroDiContribuzioni, IDcomuneAssociato);
    }
}
