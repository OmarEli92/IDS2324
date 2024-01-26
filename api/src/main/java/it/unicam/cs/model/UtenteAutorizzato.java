package it.unicam.cs.model;

import java.time.LocalDate;


/** La classe astratta Utente definisce le informazioni comuni che sono condivise
 *  tra i diversi tipi di utente che sono registrati sulla piattaforma e i metodi principali **/
public abstract class UtenteAutorizzato implements InserimentoContenuto {
    private String nome;
    private String cognome;
    private final int id;
    private final LocalDate dataDiNascita;
    private String email;
    private final String sesso;
    private String telefono;
    private int numeroDiContribuzioni;
    private final Comune comune;

    public UtenteAutorizzato(String nome, String cognome, int id, LocalDate dataDiNascita,
                             String email, String sesso, String telefono,
                             int numeroDiContribuzioni, Comune comune){
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.sesso = sesso;
        this.telefono = telefono;
        this.numeroDiContribuzioni = numeroDiContribuzioni;
        this.comune=comune;
    }

    /* Metodi Get*/
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getId() {
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

    public void aggiungiContribuzione() {
        numeroDiContribuzioni++;
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

    public void setEmail(String email) {
        //TODO
    }

    public void setTelefono(String telefono) {
        //TODO
    }

    @Override
    public void inserisciPOI(POI poi) {

    }

    @Override
    public void inserisciItinerario(Itinerario itinerario) {

    }

    @Override
    public void inserisciEvento(Evento evento) {

    }

    @Override
    public void inserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {

    }
}
