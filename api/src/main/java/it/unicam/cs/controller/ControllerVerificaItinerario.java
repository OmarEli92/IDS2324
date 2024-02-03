package it.unicam.cs.controller;

import it.unicam.cs.controller.Abstractions.AbstractControllerVerificaContenuto;
import it.unicam.cs.service.Abstractions.AbstractVerificaContenutoService;

public class ControllerVerificaItinerario extends AbstractControllerVerificaContenuto{

    public ControllerVerificaItinerario(AbstractVerificaContenutoService verificaContenutoService) {
        super(verificaContenutoService);
    }
}
