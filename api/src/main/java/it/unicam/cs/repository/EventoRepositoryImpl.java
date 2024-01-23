package it.unicam.cs.repository;

import it.unicam.cs.exception.EventoNotFoundException;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.Evento;


import java.util.Map;
/** Implementazione pre-SpringBoot della respository per gli eventi**/
public class EventoRepositoryImpl implements EventoRepository{

    private final Map<Integer, Evento> eventi;

    public EventoRepositoryImpl(Map<Integer, Evento> eventi){
        this.eventi = eventi;
    }

    @Override
    public Map<Integer, Evento> ottieniEventi() {
        return eventi;
    }

    @Override
    public Evento ottieniEventoDaID(int idEvento) throws EventoNotFoundException {
        if(eventi.containsKey(idEvento)){
            return eventi.get(idEvento);
        }
        else throw new EventoNotFoundException("L'evento non esiste");
    }

    @Override
    public void aggiungiEvento(Evento evento) {
    evento.getPoiAssociato().getComuneAssociato().getEventi().add(evento);
    }

    @Override
    public void aggiungiEventoInPending(Evento evento) {
    evento.getPoiAssociato().getComuneAssociato().getEventiInPending().add(evento);
    }
}
