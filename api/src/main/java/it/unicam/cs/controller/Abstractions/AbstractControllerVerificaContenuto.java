package it.unicam.cs.controller.Abstractions;

import it.unicam.cs.controller.Interfaces.ControllerVerificaContenuto;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.service.Abstractions.AbstractVerificaContenutoService;

public abstract class AbstractControllerVerificaContenuto implements ControllerVerificaContenuto {
    protected final AbstractVerificaContenutoService verificaContenutoService;

    public AbstractControllerVerificaContenuto(AbstractVerificaContenutoService verificaContenutoService) {
        this.verificaContenutoService = verificaContenutoService;
    }
    public void verificaContenuto(Contenuto contenuto){
        this.verificaContenutoService.verificaContenuto(contenuto);
    }
    public void validaContenuto(Contenuto contenuto){
        this.verificaContenutoService.validaContenuto(contenuto);
    }
    public void invalidaContenuto(Contenuto contenuto){
        this.verificaContenutoService.invalidaContenuto(contenuto);
    }
}
