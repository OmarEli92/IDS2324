package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Evento;
import it.unicam.cs.repository.IEventoInPendingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InserimentoEventoInPending implements Inserimento {
    @Autowired
    private IEventoInPendingRepository eventoInPendingRepository;

    @Override
    public void insert(Contenuto evento) {
        this.eventoInPendingRepository.save((Evento) evento );
    }
}
