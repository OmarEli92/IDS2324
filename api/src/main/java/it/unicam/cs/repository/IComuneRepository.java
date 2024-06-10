package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.ComuneDTO;
import it.unicam.cs.model.Utente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface IComuneRepository extends JpaRepository<Comune,Integer> {
    Comune findByNome(String nome);

    @Query(value = "SELECT c from Comune c JOIN c.POIS p WHERE p.id = :idRichiesta")
    Comune findByPOIId(@Param("idRichiesta") Integer idRichiesta);
    @Query(value = "SELECT c from Comune c JOIN c.itinerari i WHERE i.id = :idRichiesta")
    Comune findByItinerarioId(@Param("idRichiesta")Integer idRichiesta);
    @Query(value = "SELECT c from Comune c JOIN c.eventi e WHERE e.id = :idRichiesta")
    Comune findByEvento(@Param("idRichiesta")Integer idRichiesta);
    @Query(value = "SELECT c from Comune c join c.contenutiMultimediali co WHERE co.id = :idRichiesta")
    Comune findByContenutoMultimedialeId(@Param("idRichiesta")Integer idRichiesta);
    @Query("SELECT c FROM Comune c LEFT JOIN FETCH c.POIS WHERE c.nome = :nome")
    Comune findByNomeWithPOIs(@Param("nome") String nome);
    @Query("SELECT c FROM Comune c LEFT JOIN FETCH c.itinerari WHERE c.nome = :nome")
    Comune findByNomeWithItinerari(@Param("nome") String nome);
    @Query("SELECT c FROM Comune c LEFT JOIN FETCH c.eventi WHERE c.nome = :nome")
    Comune findByNomeWithEventi(@Param("nome") String nome);

    default ComuneDTO convertiComuneinDto(Comune comune){
        ComuneDTO comuneDTO = new ComuneDTO();
        comuneDTO.setId(comune.getId());
        comuneDTO.setNome(comune.getNome());
        return comuneDTO;
    }
}
