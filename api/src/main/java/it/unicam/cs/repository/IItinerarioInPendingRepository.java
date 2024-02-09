package it.unicam.cs.repository;

import it.unicam.cs.model.Itinerario;
import org.springframework.data.repository.CrudRepository;

public interface IItinerarioInPendingRepository extends CrudRepository<Itinerario,String> {
}
