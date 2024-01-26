package it.unicam.cs.controller.abstractions;

import it.unicam.cs.model.Contenuto;

public interface ControllerInserimentoContenuto {
    public void aggiungiContenuto(Contenuto contenuto);
    public void aggiungiContenutoInPending(Contenuto contenuto);
}
