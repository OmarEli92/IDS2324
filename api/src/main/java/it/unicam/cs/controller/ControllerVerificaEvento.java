package it.unicam.cs.controller;

import it.unicam.cs.controller.Abstractions.AbstractControllerVerificaContenuto;
import it.unicam.cs.service.Abstractions.AbstractVerificaContenutoService;

public class ControllerVerificaEvento extends AbstractControllerVerificaContenuto {
    public ControllerVerificaEvento(AbstractVerificaContenutoService verificaContenutoService) {
        super(verificaContenutoService);
    }
}
