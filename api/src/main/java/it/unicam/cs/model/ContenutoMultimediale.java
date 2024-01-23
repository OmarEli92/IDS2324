package it.unicam.cs.model;

import java.time.LocalDateTime;
import java.util.Objects;

/** L'interfaccia ContenutoMultimediale rappresenta un contenuto multimediale che può essere associato ad un POI o ad un itinerario **/

public class ContenutoMultimediale {
    private final Long id;
    private final String nome;
    private final byte[] contenuto;
    private final LocalDateTime dataCreazione;
    private final POI poiAssociato;
    private final Utente utenteAssociato;

    public ContenutoMultimediale(Long id, String nome, byte[] contenuto, LocalDateTime dataCreazione, POI poiAssociato, Utente utenteAssociato) {
        this.id = id;
        this.nome = nome;
        this.contenuto = contenuto;
        this.dataCreazione = dataCreazione;
        this.poiAssociato=poiAssociato;
        this.utenteAssociato=utenteAssociato;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public byte[] getContenuto() {
        return contenuto;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }
    public POI getPoiAssociato() {
        return poiAssociato;
    }

    public Utente getUtenteAssociato() {
        return utenteAssociato;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContenutoMultimediale that = (ContenutoMultimediale) o;
        return Objects.equals(id, that.id) && Objects.equals(poiAssociato, that.poiAssociato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, poiAssociato);
    }
}
