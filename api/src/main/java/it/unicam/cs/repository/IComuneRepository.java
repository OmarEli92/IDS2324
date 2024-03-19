package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComuneRepository extends JpaRepository<Comune,Integer> {
    Comune findByNome(String nome);
}
