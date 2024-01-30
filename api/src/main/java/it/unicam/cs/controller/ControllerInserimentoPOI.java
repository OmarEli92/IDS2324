package it.unicam.cs.controller;

import it.unicam.cs.controller.Abstractions.AbstractControllerInserimentoContenuti;
import it.unicam.cs.controller.Interfaces.ControllerInserimentoContenuto;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.POI;
import it.unicam.cs.service.Abstractions.AbstractinserimentoContenutoService;
import it.unicam.cs.service.InserimentoPOIService;

public class ControllerInserimentoPOI extends AbstractControllerInserimentoContenuti {
    public ControllerInserimentoPOI(AbstractinserimentoContenutoService abstractinserimentoContenutoService, Comune comune) {
        super(abstractinserimentoContenutoService, comune);
    }
}
