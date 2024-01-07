package it.unicam.cs.model;
/** L'interfaccia ContribuzioneContenuto rappresenta la contribuzione di un contenuto da parte di un utente autenticato
 ***/
public interface ContribuzioneContenuto {
    /** Il metodo inserisciPOI permette di inserire un POI **/
    public void creaPOI(POI poi);
    /** Il metodo inserisciEvento permette di inserire un Evento **/
    public void creaEvento(Evento evento);
    /** Il metodo inserisciItinerario permette di inserire un Itinerario **/
    public void creaItinerario(Itinerario itinerario);
}
