package it.unicam.cs.repository;

import it.unicam.cs.model.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface IContestRepository extends JpaRepository<Contest,Integer> {
    Contest findContestById(Integer id);
    @Query(value = "SELECT c from Contest c JOIN c.contenutiCaricati co WHERE co.id = :idRichiesta")
    Contest findContestByContenutoContestId(@Param("idRichiesta")Integer dRichiesta);
    @Query(value =  "SELECT c FROM Contest c LEFT JOIN FETCH c.partecipantiContest WHERE c.id = :idRichiesta")
    Contest caricaPartecipantiContest(@Param("idRichiesta") Integer idRichiesta);
    List<Contest> findByDataFineBeforeAndAttivoIsTrue(LocalDate localDate);
    List<Contest> findByDataInizioBeforeAndAttivoIsFalse(LocalDate localDate);
}
