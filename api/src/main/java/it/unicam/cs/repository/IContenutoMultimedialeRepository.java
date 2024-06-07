package it.unicam.cs.repository;

import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface IContenutoMultimedialeRepository extends JpaRepository<ContenutoMultimediale, Integer> {

}

