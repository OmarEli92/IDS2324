package it.unicam.cs.controller;

import it.unicam.cs.controller.Abstractions.AbstractControllerInserimentoContenuti;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.service.Abstractions.AbstractinserimentoContenutoService;
import it.unicam.cs.service.InserimentoItinerariService;
import it.unicam.cs.service.Interfaces.IInserimentoContenutiService;

public class ControllerInserimentoItinerario extends AbstractControllerInserimentoContenuti {
    public ControllerInserimentoItinerario(AbstractinserimentoContenutoService abstractinserimentoContenutoService, Comune comune) {
        super(abstractinserimentoContenutoService, comune);
    }
}
