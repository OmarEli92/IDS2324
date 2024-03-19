package it.unicam.cs.repository;

import it.unicam.cs.model.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRuoloRepository extends JpaRepository<Ruolo,Integer> {
    public Ruolo findByNome(String nome);
}
