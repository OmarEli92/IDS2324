package it.unicam.cs.service;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.repository.ItinerarioRepositoryImpl;
import it.unicam.cs.service.Interfaces.IInserimentoContenutiService;

public class InserimentoItinerariService implements IInserimentoContenutiService {
private final ItinerarioRepositoryImpl itinerarioRepository;

    public InserimentoItinerariService(ItinerarioRepositoryImpl itinerarioRepository) {
        this.itinerarioRepository = itinerarioRepository;
    }

    @Override
    public void aggiungiContenuto(Contenuto itinerario) {
        this.itinerarioRepository.aggiungiItinerario((Itinerario)itinerario);
    }

    @Override
    public void aggiungiContenutoInPending(Contenuto itinerario) {
        this.itinerarioRepository.aggiungiItinerarioInPending((Itinerario) itinerario);
    }
}
