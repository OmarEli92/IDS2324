package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.DTO.UtenteDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {
    Utente findByUsername(String username);
    Utente findUtenteById(Integer id);
    @Transactional
    default UtenteDto convertiUtenteinDto(Utente utente){
        Comune comune = utente.getComuneAssociato();
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setId(utente.getId());
        utenteDto.setNome(utente.getNome());
        utenteDto.setUsername(utente.getUsername());
        utenteDto.setComuneAssociato(comune != null ?comune.getNome():null);
        utenteDto.setCognome(utente.getCognome());
        utenteDto.setEmail(utente.getEmail());
        return utenteDto;
    }
    @Query(value = "SELECT u from Utente u JOIN u.poiCreati i WHERE i.id =: idRichiesta")
    Utente findByPOIid(Integer idRichiesta);
    @Query(value = "SELECT u from Utente u JOIN u.itinerariCreati i WHERE i.id =: idRichiesta")
    Utente findByIitinerarioId(Integer idRichiesta);
    @Query(value = "SELECT u from Utente u JOIN u.eventiCreati i WHERE i.id =: idRichiesta")
    Utente findByEventoId(Integer idRichiesta);
    @Query(value = "SELECT u from Utente u JOIN u.contenutiMultimediali c where c.id =: idRichiesta")
    Utente findByContenutoMultimedialeId(Integer idRichiesta);
}
