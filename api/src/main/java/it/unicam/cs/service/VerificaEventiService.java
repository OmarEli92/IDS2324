package it.unicam.cs.service;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Evento;
import it.unicam.cs.repository.Abstractions.AbstractContenutoRepository;
import it.unicam.cs.repository.EventoRepositoryImpl;
import it.unicam.cs.service.Abstractions.AbstractVerificaContenutoService;
import it.unicam.cs.service.Interfaces.IVerificaContenutiService;

public class VerificaEventiService extends AbstractVerificaContenutoService {
    public VerificaEventiService(AbstractContenutoRepository abstractContenutoRepository) {
        super(abstractContenutoRepository);
    }
}
