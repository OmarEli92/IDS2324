package it.unicam.cs.repository.Abstractions;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Curatore;
import it.unicam.cs.repository.Interfaces.ContenutoRepository;

public abstract class AbstractContenutoRepository implements ContenutoRepository {
protected final Comune comune;

    public AbstractContenutoRepository(Comune comune) {
        this.comune = comune;
    }

    @Override
    public void aggiungiContenuto(Contenuto contenuto) {
    }

    @Override
    public void aggiungiContenutoInPending(Contenuto contenuto) {

    }

    @Override
    public Curatore getCuratore() {
        return this.comune.getCuratore();
    }

    @Override
    public void rimuoviContenutoInPending(Contenuto contenuto) {

    }
}
