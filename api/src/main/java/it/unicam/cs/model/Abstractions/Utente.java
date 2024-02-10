package it.unicam.cs.model.Abstractions;


import it.unicam.cs.model.Comune;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "RUOLO")
public abstract class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;

    public Utente(Integer id, String nome, String cognome, LocalDate dataDiNascita,
                  String email, String sesso, String telefono, int numeroDiContribuzioni, Comune comuneAssociato) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.sesso = sesso;
        this.telefono = telefono;
        this.numeroDiContribuzioni = numeroDiContribuzioni;
        this.comuneAssociato = comuneAssociato;
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

    public Integer getId() {
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

    public Comune getComune() {
        return comuneAssociato;
    }

    public void setId(Integer id) {
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

}
