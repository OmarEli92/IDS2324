package it.unicam.cs.model;

import java.time.LocalDate;


/** La classe Curatore rappresenta colui che si occupa di verificare che i POI,gli itinerari e i contenuti
 *  aggiunti siano consoni**/
public class Curatore extends Utente {


    public Curatore(String nome, String cognome, String email, int ID,
                    LocalDate dataDiNascita, String telefono, String sesso, int idComuneAssociato) {
        super(nome, cognome, ID, dataDiNascita,email,sesso,telefono,0, idComuneAssociato);

    }

/*
    public void eliminaContenuto(int idContenuto,String tipoContenuto){

    }

    @Override
    public void inserisciPOI(POI poi) {

    }

    @Override
    public void inserisciItinerario(Itinerario itinerario) {

    }

    @Override
    public void inserisciEvento(Evento evento) {

    }

    @Override
    public void inserimentoContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {

    }*/

    public void verificaEvento(Evento evento) {
    //TODO
    }
    public void verificaPOI(POI poi){
        //TODO
    }
    public void verificaItinerario(Itinerario itinerario){
        //TODO
    }
}
