package it.unicam.cs.model.ruoli;

import it.unicam.cs.model.Comune;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

/** Un gestore della piattaforma comunale gestisce un solo comune**/
@Entity
public class GestorePiattaforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private LocalDate dataNascita;
    @OneToOne(fetch = FetchType.LAZY)
    public Comune comuneAssociato;

    public GestorePiattaforma(Integer ID, String nome, String cognome, String email,
                              String telefono, LocalDate dataNascita, Comune comuneAssociato){
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.dataNascita = dataNascita;
        this.comuneAssociato = comuneAssociato;
    }

    public GestorePiattaforma() {

    }


    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

}
