package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.UtenteAutenticato;

import java.time.LocalDate;

public class Turista extends UtenteAutenticato {
    public Turista(String nome, String cognome, int id, LocalDate dataDiNascita, String email, String sesso, String telefono, int numeroDiContribuzioni, Comune comune) {
        super(nome, cognome, id, dataDiNascita, email, sesso, telefono, numeroDiContribuzioni, comune);
    }

    @Override
    public void inserisciPOIInPending(POI poi) {

    }

    @Override
    public void InserisciEventoInPending(Evento evento) {

    }

    @Override
    public void InserisciItinerarioInPending(Itinerario itinerario) {

    }

    @Override
    public void InserisciContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale) {

    }
}



