package it.unicam.cs.repository;

import it.unicam.cs.model.Abstractions.Utente;
import org.springframework.data.repository.CrudRepository;

public interface UtenteRepository extends CrudRepository<Utente,String> {
}
