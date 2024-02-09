package it.unicam.cs.model.Abstractions;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public abstract class Utente {
    @Id
    private String id;
    @NotNull
    private  String nome;
    @NotNull
    private  String cognome;

    private  LocalDate dataDiNascita;
    @NotNull
    private String email;
    private  String sesso;
    private String telefono;
    private int numeroDiContribuzioni;
    private  String idComune;

    public Utente(String id, String nome, String cognome, LocalDate dataDiNascita,
                  String email, String sesso, String telefono, int numeroDiContribuzioni, String idComune) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.sesso = sesso;
        this.telefono = telefono;
        this.numeroDiContribuzioni = numeroDiContribuzioni;
        this.idComune = idComune;
    }

    public Utente() {

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getId() {
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

    public String getIdComune() {
        return idComune;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public void setNumeroDiContribuzioni(int numeroDiContribuzioni) {
        this.numeroDiContribuzioni = numeroDiContribuzioni;
    }

    public void setIdComune(String idComune) {
        this.idComune = idComune;
    }
}
