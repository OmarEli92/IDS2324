package it.unicam.cs.model.DTO;

public class UtenteDto {
    private Integer id;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String comuneAssociato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComuneAssociato() {
        return comuneAssociato;
    }

    public void setComuneAssociato(String comuneAssociato) {
        this.comuneAssociato = comuneAssociato;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
