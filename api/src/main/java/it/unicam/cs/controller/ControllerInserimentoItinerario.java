package it.unicam.cs.controller;

import it.unicam.cs.controller.Abstractions.AbstractControllerInserimentoContenuti;
import it.unicam.cs.model.Comune;
import it.unicam.cs.service.Abstractions.AbstractinserimentoContenutoService;

public class ControllerInserimentoItinerario extends AbstractControllerInserimentoContenuti {
    public ControllerInserimentoItinerario(AbstractinserimentoContenutoService abstractinserimentoContenutoService, Comune comune) {
        super(abstractinserimentoContenutoService, comune);
    }
}
