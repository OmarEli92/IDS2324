package it.unicam.cs.service;

import it.unicam.cs.repository.Abstractions.AbstractContenutoRepository;
import it.unicam.cs.service.Abstractions.AbstractVerificaContenutoService;

public class VerificaItinerarioService extends AbstractVerificaContenutoService {
    public VerificaItinerarioService(AbstractContenutoRepository abstractContenutoRepository) {
        super(abstractContenutoRepository);
    }
}
