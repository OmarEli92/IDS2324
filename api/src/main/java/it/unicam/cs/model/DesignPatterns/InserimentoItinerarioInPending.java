package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.repository.IItinerarioInPendingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InserimentoItinerarioInPending implements Inserimento {
    @Autowired
    private IItinerarioInPendingRepository itinerarioInPendingRepository;

    @Override
    public void insert(Contenuto itinerario) {
        this.itinerarioInPendingRepository.save((Itinerario) itinerario);
    }
}
