package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.repository.IItinerarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InserimentoItinerario implements Inserimento{
    @Autowired
    private IItinerarioRepository itinerarioRepository;

    @Override
    public void insert(Contenuto itinerario) {
        this.itinerarioRepository.save((Itinerario) itinerario);
    }
}
