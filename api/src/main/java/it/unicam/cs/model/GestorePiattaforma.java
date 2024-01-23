package it.unicam.cs.model;

import java.time.LocalDate;

/** Un gestore della piattaforma comunale gestisce un solo comune**/
public class GestorePiattaforma {
    private final int ID;
    private final String nome;
    private final String cognome;
    private String email;
    private final String telefono;
    private final LocalDate dataNascita;
    public final int IDComuneAssociato;

    public GestorePiattaforma(int ID, String nome, String cognome, String email,
                              String telefono, LocalDate dataNascita,int IDComuneAssociato){
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.dataNascita = dataNascita;
        this.IDComuneAssociato = IDComuneAssociato;
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
