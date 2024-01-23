package it.unicam.cs.model;
/** La classe Curatore rappresenta colui che si occupa di verificare che i POI,gli itinerari e i contenuti
 *  aggiunti siano consoni**/
public class Curatore implements InserimentoContenuto{
    private final String nome;
    private final String cognome;
    private final String email;
    private final int idComuneAssociato;
    private final int dataDiNascita;
    private final String ID;
    private final String telefono;
    private final String sesso;

    public Curatore(String nome, String cognome, String email, String ID,
                    int dataDiNascita, String telefono, String sesso, int idComuneAssociato) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ID = ID;
        this.dataDiNascita = dataDiNascita;
        this.telefono = telefono;
        this.sesso = sesso;
        this.idComuneAssociato = idComuneAssociato;
    }

    public void verificaContenuto(){

    }

    public void eliminaContenuto(int idContenuto,String tipoContenuto){

    }

    @Override
    public void InserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale,Comune comune) {

    }
    @Override
    public void inserisciPOI(POI poi,Comune comune) {

    }

    @Override
    public void inserisciItinerario(Itinerario itinerario,Comune comune) {

    }

    @Override
    public void inserisciEvento(Evento evento,Comune comune) {

    }
}
