package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Contenuto;

public abstract class AbstractFactoryInserimento {
    public abstract Inserimento getInserimento(Contenuto tipo);
}
