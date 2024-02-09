package it.unicam.cs.repository;

import it.unicam.cs.model.ContenutoMultimediale;
import org.springframework.data.repository.CrudRepository;

public interface IContenutoMultimedialeInPendingRepository extends CrudRepository<ContenutoMultimediale, String> {
}
