package it.unicam.cs.model.ruoli;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Utente;

import java.time.LocalDate;

public class Animatore extends Utente {
    public Animatore(Integer id, String nome, String cognome, LocalDate dataDiNascita,
                     String email, String sesso, String telefono, int numeroContribuzioni, Comune comune) {
        super(id, nome, cognome, dataDiNascita, email, sesso, telefono, numeroContribuzioni, comune);
    }

}
