package it.unicam.cs.model;


import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Interfaces.InserimentoContenutoInPending;

import java.time.LocalDate;

public class Contributor extends Utente implements InserimentoContenutoInPending {

    public Contributor(String nome, String cognome, String id, LocalDate dataDiNascita, String email,
                       String sesso, String telefono, int numeroDiContribuzioni, String idComune
                       ) {
        super(nome, cognome, id, dataDiNascita, email, sesso, telefono, numeroDiContribuzioni, idComune);
    }


    @Override
    public void inserisciPOIInPending(POI poi) {
        //TODO
    }

    @Override
    public void InserisciEventoInPending(Evento evento) {
        //TODO
    }

    @Override
    public void InserisciItinerarioInPending(Itinerario itinerario) {
        //TODO
    }

    @Override
    public void InserisciContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale) {
        //TODO
    }
}
