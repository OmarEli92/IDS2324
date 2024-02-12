package it.unicam.cs.model;


import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Interfaces.InserimentoContenutoInPending;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;
@Entity
@DiscriminatorValue("Contributor")
public class Contributor extends Utente implements InserimentoContenutoInPending {

    public Contributor(String nome, String cognome, Integer id, LocalDate dataDiNascita, String email,
                       String sesso, String telefono, int numeroDiContribuzioni, Comune comuneAssociato
                       ) {
        super(id,nome, cognome, dataDiNascita, email, sesso, telefono, numeroDiContribuzioni, comuneAssociato);
    }

    public Contributor() {

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
