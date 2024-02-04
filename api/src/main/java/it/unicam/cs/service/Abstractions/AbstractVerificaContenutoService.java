package it.unicam.cs.service.Abstractions;

import it.unicam.cs.service.Interfaces.IVerificaContenutiService;

public abstract class AbstractVerificaContenutoService implements IVerificaContenutiService {
    protected final AbstractContenutoRepository abstractContenutoRepository;

    public AbstractVerificaContenutoService(AbstractContenutoRepository abstractContenutoRepository) {
        this.abstractContenutoRepository = abstractContenutoRepository;
    }

    @Override
    public void verificaContenuto(Contenuto contenuto) {
        this.abstractContenutoRepository.getCuratore().verificaContenuto(contenuto);
    }

    @Override
    public void validaContenuto(Contenuto contenuto) {
        this.abstractContenutoRepository.rimuoviContenutoInPending(contenuto);
        this.abstractContenutoRepository.aggiungiContenuto(contenuto);
    }

    @Override
    public void invalidaContenuto(Contenuto contenuto) {
        this.abstractContenutoRepository.rimuoviContenutoInPending(contenuto);
    }
}
