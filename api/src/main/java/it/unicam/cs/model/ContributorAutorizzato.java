package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Interfaces.InserimentoContenuto;

import java.time.LocalDate;

public class ContributorAutorizzato extends Utente implements InserimentoContenuto {
    public ContributorAutorizzato(String nome, String cognome, Integer id, LocalDate dataDiNascita,
                                  String email, String sesso, String telefono, int numeroDiContribuzioni,
                                  Comune comuneAssociato) {
        super(id,nome, cognome, dataDiNascita, email, sesso, telefono, numeroDiContribuzioni, comuneAssociato);
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
