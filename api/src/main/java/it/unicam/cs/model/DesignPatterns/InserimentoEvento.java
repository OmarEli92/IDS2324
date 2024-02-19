package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Evento;
import it.unicam.cs.repository.IEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InserimentoEvento implements Inserimento{
    @Autowired
    private IEventoRepository eventoRepository;

    @Override
    public void insert(Contenuto evento) {
        this.eventoRepository.save((Evento) evento);
    }
}
