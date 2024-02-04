package it.unicam.cs.controller.Interfaces;

import it.unicam.cs.model.Abstractions.Contenuto;

public interface ControllerInserimentoContenuto {
    public void aggiungiContenuto(Contenuto contenuto);
    public void aggiungiContenutoInPending(Contenuto contenuto);
}
