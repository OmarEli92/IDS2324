package it.unicam.cs.repository;

import it.unicam.cs.model.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IContestRepository extends JpaRepository<Contest,Integer> {
    Contest findContestById(Integer id);
    @Query(value = "SELECT c from Contest c JOIN c.contenutiCreati co WHERE co.id =: idRichiesta")
    Contest findContestByContenutoContestId(Integer dRichiesta);
}
