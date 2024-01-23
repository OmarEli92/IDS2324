package it.unicam.cs.model;

import it.unicam.cs.util.Ruolo;
import it.unicam.cs.util.Tipo;

import java.time.LocalDate;


/** La classe astratta Utente definisce le informazioni comuni che sono condivise
 *  tra i diversi tipi di utente che sono registrati sulla piattaforma e i metodi principali **/
public class Utente implements InserimentoContenuto {
    private final String nome;
    private final String cognome;
    private final int id;
    private final LocalDate dataDiNascita;
    private String email;
    private final String sesso;
    private String telefono;
    private int numeroDiContribuzioni;
    private final Ruolo ruolo;

    public Utente(String nome, String cognome, int id, LocalDate dataDiNascita,
                  String email, String sesso, String telefono,
                  int numeroDiContribuzioni, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.sesso = sesso;
        this.telefono = telefono;
        this.numeroDiContribuzioni = numeroDiContribuzioni;
        this.ruolo = ruolo;
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
    public String getRuolo() {
        return ruolo.toString();
    }

    public int getNumeroDiContribuzioni() {
        return numeroDiContribuzioni;
    }

    public void aggiungiContribuzione() {
        numeroDiContribuzioni++;
    }

    @Override
    public void inserisciPOI(POI poi,Comune comune) {
        if(this.getRuolo()=="contributore")
            comune.addPoiInPending(poi);
        else
            comune.addPOI(poi);
    }

    @Override
    public void inserisciItinerario(Itinerario itinerario,Comune comune) {
        if(this.getRuolo()=="contributore")
            comune.addItinerarioInPending(itinerario);
        else
            comune.addItinerarioInPending(itinerario);
    }

    @Override
    public void inserisciEvento(Evento evento,Comune comune) {
        if(this.getRuolo()=="contributore")
            comune.addEventoInPending(evento);
        else
            comune.addEvento(evento);
    }
    @Override
    public void InserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale,Comune comune) {
        if(this.getRuolo()=="contributore")
            contenutoMultimediale.getPoiAssociato().addContenutiMultimedialeInPending(contenutoMultimediale);
        else
            contenutoMultimediale.getPoiAssociato().addContenutiMultimediale(contenutoMultimediale);
    }
    public void eliminaContenuto (ContenutoMultimediale contenutoMultimediale,POI poi){
        if(this.getRuolo()=="contributore autorizzato")
        poi.eliminaContenutoMultimediale(contenutoMultimediale);
    }

}
