package it.unicam.cs.model;

import java.time.LocalDateTime;

/** L'interfaccia ContenutoMultimediale rappresenta un contenuto multimediale che può essere associato ad un POI o ad un itinerario **/

public interface ContenutoMultimediale {
    Long getId();
    String getNomeFile();
    String getTipoContenuto();
    byte[] getContenuto();
    LocalDateTime getDataCreazione();

}
