package it.unicam.cs.repository;

import it.unicam.cs.model.contenuti.ContenutoContest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContenutoContestRepository extends JpaRepository<ContenutoContest, Integer> {

}
