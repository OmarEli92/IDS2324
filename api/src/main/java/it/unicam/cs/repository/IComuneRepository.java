package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IComuneRepository extends JpaRepository<Comune,Integer> {
    Comune findByNome(String nome);
    @Query(value = "SELECT from Comune c JOIN c.POIS p WHERE p.id =: idRichiesta")
    Comune findByPOIId(Integer idRichiesta);
    @Query(value = "SELECT from Comune c JOIN c.itinerari WHERE c.id =: idRichiesta")
    Comune findByItinerarioId(Integer idRichiesta);
}
