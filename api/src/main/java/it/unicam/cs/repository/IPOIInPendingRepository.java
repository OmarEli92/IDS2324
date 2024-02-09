package it.unicam.cs.repository;

import it.unicam.cs.model.POI;
import org.springframework.data.repository.CrudRepository;

public interface IPOIInPendingRepository extends CrudRepository<POI, String> {
}
