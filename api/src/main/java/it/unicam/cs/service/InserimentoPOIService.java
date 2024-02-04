package it.unicam.cs.service;

import it.unicam.cs.service.Abstractions.AbstractinserimentoContenutoService;

public class InserimentoPOIService extends AbstractinserimentoContenutoService{
    public InserimentoPOIService(AbstractContenutoRepository abstractContenutoRepository) {
        super(abstractContenutoRepository);
    }
}
