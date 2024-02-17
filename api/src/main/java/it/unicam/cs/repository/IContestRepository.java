package it.unicam.cs.repository;

import it.unicam.cs.model.Contest;
import org.springframework.data.repository.CrudRepository;

public interface IContestRepository extends CrudRepository<Contest,Integer> {
}
