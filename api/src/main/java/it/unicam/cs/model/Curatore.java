package it.unicam.cs.model;
/** La classe Curatore rappresenta colui che si occupa di verificare che i POI,gli itinerari e i contenuti
 *  aggiunti siano consoni**/
public class Curatore {
    private final String nome;
    private final String cognome;
    private final String email;
    private final String ID;

    public Curatore(String nome, String cognome, String email, String ID) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ID = ID;
    }
}
