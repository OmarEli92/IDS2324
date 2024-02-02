package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.Tipo;

import java.time.LocalDateTime;
import java.util.List;

public class POITuristico extends POI{

    public POITuristico(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore, Posizione posizione, Tipo tipo, List<ContenutoMultimediale> contenutiMultimediali, List<ContenutoMultimediale> contenutiMultimedialiInPending) {
        super(comuneAssociato, id, nome, utenteCreatore, posizione, tipo, contenutiMultimediali, contenutiMultimedialiInPending);
    }
}
