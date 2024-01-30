package it.unicam.cs.model.Abstractions;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Interfaces.InserimentoContenuto;
import it.unicam.cs.model.Interfaces.InserimentoContenutoInPending;

import java.time.LocalDate;

public abstract class UtenteAutenticato implements InserimentoContenutoInPending {
    private String nome;
    private String cognome;
    private final int id;
    private final LocalDate dataDiNascita;
    private String email;
    private final String sesso;
    private String telefono;
    private int numeroDiContribuzioni;
    private final Comune comune;

    public UtenteAutenticato(String nome, String cognome, int id, LocalDate dataDiNascita, String email, String sesso, String telefono, int numeroDiContribuzioni, Comune comune) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.sesso = sesso;
        this.telefono = telefono;
        this.numeroDiContribuzioni = numeroDiContribuzioni;
        this.comune = comune;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new NullPointerException("Il nome deve avere almeno un carattere");
        }
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        if (cognome == null || cognome.isEmpty()) {
            throw new NullPointerException("Il cognome deve avere almeno un carattere");
        }
        this.cognome = cognome;
    }
}
