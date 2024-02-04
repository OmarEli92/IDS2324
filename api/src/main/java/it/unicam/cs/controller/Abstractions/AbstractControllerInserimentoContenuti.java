package it.unicam.cs.controller.Abstractions;

import it.unicam.cs.controller.Interfaces.ControllerInserimentoContenuto;
import it.unicam.cs.model.Comune;
import it.unicam.cs.service.Abstractions.AbstractinserimentoContenutoService;

public abstract class AbstractControllerInserimentoContenuti implements ControllerInserimentoContenuto {
    protected final AbstractinserimentoContenutoService abstractinserimentoContenutoService;
    protected final Comune comune;

    public AbstractControllerInserimentoContenuti(AbstractinserimentoContenutoService abstractinserimentoContenutoService, Comune comune) {
        this.abstractinserimentoContenutoService = abstractinserimentoContenutoService;
        this.comune=comune;
    }

    @Override
    public void aggiungiContenuto(Contenuto contenuto) {
        this.abstractinserimentoContenutoService.aggiungiContenuto(contenuto);
    }

    @Override
    public void aggiungiContenutoInPending(Contenuto contenuto) {
        this.abstractinserimentoContenutoService.aggiungiContenutoInPending(contenuto);
    }
}
