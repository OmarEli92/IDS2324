package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Evento;
import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.model.Abstractions.UtenteAutorizzato;

import java.time.LocalDate;

public class ContributorAutorizzato extends UtenteAutorizzato {
    public ContributorAutorizzato(String nome, String cognome, int id, LocalDate dataDiNascita, String email, String sesso, String telefono, int numeroDiContribuzioni, Comune comune) {
        super(nome, cognome, id, dataDiNascita, email, sesso, telefono, numeroDiContribuzioni, comune);
    }

    @Override
    public void inserisciPOI(POI poi) {
        //TODO
    }

    @Override
    public void inserisciItinerario(Itinerario itinerario) {
        //TODO
    }

    @Override
    public void inserisciEvento(Evento evento) {
        //TODO
    }

    @Override
    public void inserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        //TODO
    }
}
