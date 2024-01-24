package it.unicam.cs.repository;

import it.unicam.cs.exception.EventoNotFoundException;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.Evento;


import java.util.Map;
import java.util.stream.Collectors;

/** Implementazione pre-SpringBoot della respository per gli eventi**/
public class EventoRepositoryImpl implements EventoRepository{
    private final Map<Integer, Evento> eventi;

    public EventoRepositoryImpl(Map<Integer, Evento> eventi){
        this.eventi = eventi;
    }

    @Override
    public Map<Integer, Evento> ottieniEventi(int idComune) {
        return eventi.values()
                .stream()
                .filter(evento -> evento.getIdComune() == idComune)
                .collect(Collectors.toMap(Evento::getID, evento -> evento));

    }

    @Override
    public Evento ottieniEventoDaID(int idEvento){
        return eventi.get(idEvento);
    }
}
