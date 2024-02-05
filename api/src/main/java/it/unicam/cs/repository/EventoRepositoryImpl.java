package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Evento;
import it.unicam.cs.repository.Interfaces.IEventoRepository;

import java.util.Map;
import java.util.stream.Collectors;

/** Implementazione pre-SpringBoot della respository per gli eventi**/
public class EventoRepositoryImpl implements IEventoRepository {
    private final Map<Integer, Evento> eventi;

    public EventoRepositoryImpl(Map<Integer, Evento> eventi){
        this.eventi=eventi;
    }


    public Map<Integer, Evento> ottieniEventi(int idComune) {
        return eventi.values()
                .stream()
                .filter(evento -> evento.getPoiAssociato().getComuneAssociato().getID() == idComune)
                .collect(Collectors.toMap(Evento::getId, evento -> evento));
    }


    public Evento ottieniEventoDaID(int idEvento) {
        return eventi.get(idEvento);
    }
    @Override
    public void aggiungiEvento(Evento evento) {
        eventi.put(evento.getId(),evento);
    }

    @Override
    public void aggiungiEventoInPending(Evento evento) {

    }

    public void rimuoviEventoInPending(Evento evento) {

    }
}
