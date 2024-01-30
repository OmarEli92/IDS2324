package it.unicam.cs.service;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.repository.Abstractions.AbstractContenutoRepository;
import it.unicam.cs.repository.ItinerarioRepositoryImpl;
import it.unicam.cs.service.Abstractions.AbstractinserimentoContenutoService;
import it.unicam.cs.service.Interfaces.IInserimentoContenutiService;

public class InserimentoItinerariService extends AbstractinserimentoContenutoService {
    public InserimentoItinerariService(AbstractContenutoRepository abstractContenutoRepository) {
        super(abstractContenutoRepository);
    }
}
