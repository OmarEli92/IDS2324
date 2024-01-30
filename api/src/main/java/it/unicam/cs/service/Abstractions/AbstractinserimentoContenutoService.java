package it.unicam.cs.service.Abstractions;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.repository.Abstractions.AbstractContenutoRepository;
import it.unicam.cs.service.Interfaces.IInserimentoContenutiService;

public abstract class AbstractinserimentoContenutoService implements IInserimentoContenutiService {
    protected final AbstractContenutoRepository abstractContenutoRepository;

    public AbstractinserimentoContenutoService(AbstractContenutoRepository abstractContenutoRepository) {
        this.abstractContenutoRepository = abstractContenutoRepository;
    }

    @Override
    public void aggiungiContenuto(Contenuto contenuto) {
        this.abstractContenutoRepository.aggiungiContenuto(contenuto);
    }

    @Override
    public void aggiungiContenutoInPending(Contenuto contenuto) {
        this.abstractContenutoRepository.aggiungiContenutoInPending(contenuto);
    }
}
