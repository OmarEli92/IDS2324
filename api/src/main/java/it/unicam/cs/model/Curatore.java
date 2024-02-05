package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.UtenteAutorizzato;
import it.unicam.cs.model.Interfaces.VerificaContenuto;

import java.time.LocalDate;


/** La classe Curatore rappresenta colui che si occupa di verificare che i POI,gli itinerari e i contenuti
 *  aggiunti siano consoni**/
public class Curatore extends UtenteAutorizzato implements VerificaContenuto {


    public Curatore(String nome, String cognome, String email, int ID,
                    LocalDate dataDiNascita, String telefono, String sesso, Comune comune) {
        super(nome, cognome, ID, dataDiNascita,email,sesso,telefono,0, comune);

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
    public void validaPOI(POI poi) {

    }

    @Override
    public void validaEvento(Evento evento) {

    }

    @Override
    public void validaItinerario(Itinerario itinerario) {

    }

    @Override
    public void validaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {

    }
}
