package it.unicam.cs.repository;

import it.unicam.cs.model.abstractions.Utente;
import org.springframework.data.repository.CrudRepository;

public interface UtenteRepository extends CrudRepository<Utente,Integer> {
}
