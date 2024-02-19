package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.repository.ContenutoMultimedialeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InserimentoContenutoMultimediale implements Inserimento{
    @Autowired
    private ContenutoMultimedialeRepository contenutoMultimedialeRepository;

    @Override
    public void insert(Contenuto contenutoMultimediale) {
        this.contenutoMultimedialeRepository.save((ContenutoMultimediale) contenutoMultimediale);
    }
}
