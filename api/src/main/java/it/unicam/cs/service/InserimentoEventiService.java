package it.unicam.cs.service;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Evento;
import it.unicam.cs.repository.Abstractions.AbstractContenutoRepository;
import it.unicam.cs.repository.EventoRepositoryImpl;
import it.unicam.cs.service.Abstractions.AbstractinserimentoContenutoService;
import it.unicam.cs.service.Interfaces.IInserimentoContenutiService;

public class InserimentoEventiService extends AbstractinserimentoContenutoService {
    public InserimentoEventiService(AbstractContenutoRepository abstractContenutoRepository) {
        super(abstractContenutoRepository);
    }

}
