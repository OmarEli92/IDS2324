package it.unicam.cs.service;

import it.unicam.cs.repository.Abstractions.AbstractContenutoRepository;
import it.unicam.cs.service.Abstractions.AbstractVerificaContenutoService;

public class VerificaEventiService extends AbstractVerificaContenutoService {
    public VerificaEventiService(AbstractContenutoRepository abstractContenutoRepository) {
        super(abstractContenutoRepository);
    }
}
