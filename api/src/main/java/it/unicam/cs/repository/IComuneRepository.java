package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.ComuneDTO;
import it.unicam.cs.model.DTO.UtenteDto;
import it.unicam.cs.model.Utente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IComuneRepository extends JpaRepository<Comune,Integer> {
    Comune findByNome(String nome);

    @Query(value = "SELECT from Comune c JOIN c.POIS p WHERE p.id =: idRichiesta")
    Comune findByPOIId(Integer idRichiesta);
    @Query(value = "SELECT from Comune c JOIN c.itinerari i WHERE i.id =: idRichiesta")
    Comune findByItinerarioId(Integer idRichiesta);
    @Query(value = "SELECT from Comune c JOIN c.eventi e WHERE e.id =: idRichiesta")
    Comune findByEvento(Integer idRichiesta);
    @Query(value = "SELECT from Comune c join c.contenutiMultimediali co WHERE co.id := idRichiesta")
    Comune findByContenutoMultimedialeId(Integer idRichiesta);

    default ComuneDTO convertiComuneinDto(Comune comune){
        ComuneDTO comuneDTO = new ComuneDTO();
        comuneDTO.setId(comune.getId());
        comuneDTO.setNome(comune.getNome());
        return comuneDTO;
    }
}
