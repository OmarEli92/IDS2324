package it.unicam.cs.util.info;

import jakarta.persistence.Embeddable;

import java.util.Objects;

/** La classe Posizione rappresenta la posizione di un POI o di un itinerario nel territorio comunale **/
@Embeddable
public class Posizione {
    private double latitudine;
    private double longitudine;

    public Posizione(double latitudine, double longitudine) {
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public Posizione() {

    }

    public double getLatitudine() {
        return latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posizione posizione = (Posizione) o;
        return Double.compare(latitudine, posizione.latitudine) == 0 && Double.compare(longitudine, posizione.longitudine) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitudine, longitudine);
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }
}
