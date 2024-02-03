package it.unicam.cs.model;


import it.unicam.cs.model.Abstractions.Evento;
import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.model.Interfaces.InserimentoContenutoInPending;

import java.time.LocalDate;

public class Contributor extends UtenteAutenticato implements InserimentoContenutoInPending {

    public Contributor(String nome, String cognome, int id, LocalDate dataDiNascita, String email,
                       String sesso, String telefono, int numeroDiContribuzioni, Comune comune
                       ) {
        super(nome, cognome, id, dataDiNascita, email, sesso, telefono, numeroDiContribuzioni, comune);
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
