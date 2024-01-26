package it.unicam.cs.model;

import java.time.LocalDate;


/** La classe Curatore rappresenta colui che si occupa di verificare che i POI,gli itinerari e i contenuti
 *  aggiunti siano consoni**/
public class Curatore extends UtenteAutorizzato implements VerificaContenuto {


    public Curatore(String nome, String cognome, String email, int ID,
                    LocalDate dataDiNascita, String telefono, String sesso, Comune comune) {
        super(nome, cognome, ID, dataDiNascita,email,sesso,telefono,0, comune);

    }

    @Override
    public void verificaPOI(POI poi) {
        //TODO
    }

    @Override
    public void verificaEvento(Evento evento) {
        //TODO
    }

    @Override
    public void verificaItinerario(Itinerario itinerario) {
        //TODO
    }

    @Override
    public void verificaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        //TODO
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


}
