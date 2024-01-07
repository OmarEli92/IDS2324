package it.unicam.cs.util;
/** La classe Posizione rappresenta la posizione di un POI o di un itinerario nel territorio comunale **/
public class Posizione {
    private final double latitudine;
    private final double longitudine;

    public Posizione(double latitudine, double longitudine) {
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }
}
