package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.repository.IContenutoMultimedialeInPendingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InserimentoContenutoMultimedialeInPending implements Inserimento {
    @Autowired
    private IContenutoMultimedialeInPendingRepository contenutoMultimedialeInPendingRepository;

    @Override
    public void insert(Contenuto contenutoMultimediale) {
        this.contenutoMultimedialeInPendingRepository.save((ContenutoMultimediale) contenutoMultimediale);
    }
}
