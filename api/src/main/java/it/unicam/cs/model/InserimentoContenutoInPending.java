package it.unicam.cs.model;

public interface InserimentoContenutoInPending {
    public void inserisciPOIInPending(POI poi);
    public void InserisciEventoInPending(Evento evento);
    public void InserisciItinerarioInPending(Itinerario itinerario);
    public void InserisciContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale);
}
