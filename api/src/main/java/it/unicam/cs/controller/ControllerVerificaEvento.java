package it.unicam.cs.controller;

import it.unicam.cs.controller.Abstractions.AbstractControllerVerificaContenuto;
import it.unicam.cs.controller.Interfaces.ControllerVerificaContenuto;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Evento;
import it.unicam.cs.service.Abstractions.AbstractVerificaContenutoService;
import it.unicam.cs.service.VerificaEventiService;

public class ControllerVerificaEvento extends AbstractControllerVerificaContenuto {
    public ControllerVerificaEvento(AbstractVerificaContenutoService verificaContenutoService) {
        super(verificaContenutoService);
    }
}
