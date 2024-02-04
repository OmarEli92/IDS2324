package it.unicam.cs.service;

import it.unicam.cs.service.Abstractions.AbstractVerificaContenutoService;

public class VerificaEventiService extends AbstractVerificaContenutoService {
    public VerificaEventiService(AbstractContenutoRepository abstractContenutoRepository) {
        super(abstractContenutoRepository);
    }
}
