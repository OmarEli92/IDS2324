package it.unicam.cs.controller;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.service.VerificaContenutoMultimedialeService;

public class ControllerVerificaContenutoMultimediale {
    private final VerificaContenutoMultimedialeService verificaContenutoMultimedialeService;
    private final Comune comune;

    public ControllerVerificaContenutoMultimediale(VerificaContenutoMultimedialeService verificaContenutoMultimedialeService,Comune comune) {
        this.verificaContenutoMultimedialeService = verificaContenutoMultimedialeService;
        this.comune=comune;
    }
    public void verificaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        this.verificaContenutoMultimedialeService.verificaContenutoMultimediale(contenutoMultimediale);
    }
    public void validaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        this.verificaContenutoMultimedialeService.validaContenutoMultimediale(contenutoMultimediale);
    }
    public void invaidaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        this.verificaContenutoMultimedialeService.invalidaContenutoMultimediale(contenutoMultimediale);
    }
}
