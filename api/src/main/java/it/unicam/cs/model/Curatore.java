package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.model.Interfaces.InserimentoContenuto;
import it.unicam.cs.model.Interfaces.VerificaContenuto;

import java.time.LocalDate;


/** La classe Curatore rappresenta colui che si occupa di verificare che i POI,gli itinerari e i contenuti
 *  aggiunti siano consoni**/
public class Curatore extends Utente implements VerificaContenuto, InserimentoContenuto {


    public Curatore(String nome, String cognome, String email, String id,
                    LocalDate dataDiNascita, String telefono, String sesso, String idComune) {
        super(nome, cognome, id, dataDiNascita,email,sesso,telefono,0, idComune);

    }


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

    @Override
    public void inserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {

    }


    @Override
    public void verificaPOI(POI poi) {

    }

    @Override
    public void verificaEvento(Evento evento) {

    }

    @Override
    public void verificaItinerario(Itinerario itinerario) {

    }
}
