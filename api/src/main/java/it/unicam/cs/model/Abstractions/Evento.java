package it.unicam.cs.model.Abstractions;


import java.util.Objects;

import it.unicam.cs.model.Comune;


/** La classe Evento rappresenta un evento che si svolge in un determinato giorno e in un determinato luogo **/
public abstract class Evento extends Contenuto {
    private POI poiAssociato;

    public Evento(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore, POI poiAssociato) {
        super(comuneAssociato, id, nome, utenteCreatore);
        this.poiAssociato = poiAssociato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Evento evento = (Evento) o;
        return Objects.equals(poiAssociato, evento.poiAssociato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), poiAssociato);
    }

    public int get1(){
        return 1;
    }
}
