package it.unicam.cs.model;

public interface VerificaContenuto {
    public void verificaPOI(POI poi);
    public void verificaEvento(Evento evento);
    public void verificaItinerario(Itinerario itinerario);
    public void verificaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale);
}

