package it.unicam.cs.model;

import java.time.LocalDate;

public class Contributor extends Utente implements InserimentoContenuto{

    private final Ruolo ruolo;
    public Contributor(String nome, String cognome, int id, LocalDate dataDiNascita, String email,
                       String sesso, String telefono, int numeroDiContribuzioni, int IDcomuneAssociato,
                       Ruolo ruolo) {
        super(nome, cognome, id, dataDiNascita, email, sesso, telefono, numeroDiContribuzioni, IDcomuneAssociato);
        this.ruolo = ruolo;
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
    public void inserimentoContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {

    }
}
