package it.unicam.cs.service;

import it.unicam.cs.repository.Abstractions.AbstractContenutoRepository;
import it.unicam.cs.service.Abstractions.AbstractinserimentoContenutoService;

public class InserimentoEventiService extends AbstractinserimentoContenutoService {
    public InserimentoEventiService(AbstractContenutoRepository abstractContenutoRepository) {
        super(abstractContenutoRepository);
    }

}
