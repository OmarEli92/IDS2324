package it.unicam.cs.model.ruoli;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.abstractions.Utente;
import it.unicam.cs.model.Interfaces.InserimentoContenuto;
import it.unicam.cs.model.Interfaces.VerificaContenuto;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;


/** La classe Curatore rappresenta colui che si occupa di verificare che i POI,gli itinerari e i contenuti
 *  aggiunti siano consoni**/
@Entity
@DiscriminatorValue("Curatore")
public class Curatore extends Utente implements VerificaContenuto, InserimentoContenuto {


    public Curatore(String nome, String cognome, String email, Integer id,
                    LocalDate dataDiNascita, String telefono, String sesso, Comune comuneAssociato) {
        super(id,nome, cognome, dataDiNascita,email,sesso,telefono,0, comuneAssociato);

    }

    public Curatore() {

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
