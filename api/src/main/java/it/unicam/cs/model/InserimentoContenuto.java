package it.unicam.cs.model;

public interface InserimentoContenuto {
    /** Il metodo inserisciPOI permette di inserire un POI **/
    void inserisciPOI(POI poi,Comune comune);
    /** Il metodo inserisciItinerario permette di inserire un Itinerario **/
    void inserisciItinerario(Itinerario itinerario,Comune comune);
    /** Il metodo inserisciEvento permette di inserire un Evento **/
    void inserisciEvento(Evento evento,Comune comune);
    /*Il metodo inserisciContenutoMultimediale permette di inserire un ContenutoMultimediale*/
    void InserisciContenutoMultimediale (ContenutoMultimediale contenutoMultimediale, Comune comune);
}
