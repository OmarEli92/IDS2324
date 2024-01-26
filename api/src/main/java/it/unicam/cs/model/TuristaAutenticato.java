package it.unicam.cs.model;

import java.time.LocalDate;

public class TuristaAutenticato extends UtenteAutenticato implements InserimentoContenutoInPending {
    public TuristaAutenticato(String nome, String cognome, int id, LocalDate dataDiNascita, String email, String sesso, String telefono, int numeroDiContribuzioni, Comune comune) {
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
