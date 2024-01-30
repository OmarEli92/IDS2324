package it.unicam.cs.service;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.Abstractions.AbstractContenutoRepository;
import it.unicam.cs.repository.POIRepositoryImpl;
import it.unicam.cs.service.Abstractions.AbstractinserimentoContenutoService;
import it.unicam.cs.service.Interfaces.IInserimentoContenutiService;

public class InserimentoPOIService extends AbstractinserimentoContenutoService{
    public InserimentoPOIService(AbstractContenutoRepository abstractContenutoRepository) {
        super(abstractContenutoRepository);
    }
}
