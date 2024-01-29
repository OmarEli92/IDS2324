package it.unicam.cs.controller;

import it.unicam.cs.controller.Abstractions.AbstractControllerVerificaContenuto;
import it.unicam.cs.controller.Interfaces.ControllerVerificaContenuto;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.service.Abstractions.AbstractVerificaContenutoService;
import it.unicam.cs.service.VerificaItinerarioService;

public class ControllerVerificaItinerario extends AbstractControllerVerificaContenuto{

    public ControllerVerificaItinerario(AbstractVerificaContenutoService verificaContenutoService) {
        super(verificaContenutoService);
    }
}
