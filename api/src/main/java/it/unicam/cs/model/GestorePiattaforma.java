package it.unicam.cs.model;

import java.time.LocalDate;
import java.util.List;

/** Un gestore della piattaforma comunale gestisce un solo comune**/
public class GestorePiattaforma {
    private final int ID;
    private final String nome;
    private final String cognome;
    private String email;
    private final String telefono;
    private final LocalDate dataNascita;
    public final List<Comune> comuni;

    public GestorePiattaforma(int ID, String nome, String cognome, String email,
                              String telefono, LocalDate dataNascita, List<Comune> comuni){
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.dataNascita = dataNascita;
        this.comuni=comuni;
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
