package it.unicam.cs.repository;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.contenuti.ContenutoContest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface IContenutoContestRepository extends JpaRepository<ContenutoContest, Integer> {

}
