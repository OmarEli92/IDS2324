package it.unicam.cs.model;

import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.Tipo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
public abstract class POI extends Contenuto {
    private final Posizione posizione;
    private final Tipo tipo;

    public POI(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore, Posizione posizione, Tipo tipo) {
        super(comuneAssociato, id, nome, utenteCreatore);
        this.posizione = posizione;
        this.tipo = tipo;
    }
}


