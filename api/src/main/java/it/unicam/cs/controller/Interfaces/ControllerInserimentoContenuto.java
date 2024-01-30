package it.unicam.cs.controller.Interfaces;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contenuto;

public interface ControllerInserimentoContenuto {
    public void aggiungiContenuto(Contenuto contenuto);
    public void aggiungiContenutoInPending(Contenuto contenuto);
}
