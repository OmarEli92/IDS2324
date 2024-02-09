package it.unicam.cs.repository;

import it.unicam.cs.model.Evento;
import org.springframework.data.repository.CrudRepository;

public interface IEventoInPendingRepository extends CrudRepository<Evento,String> {
}
