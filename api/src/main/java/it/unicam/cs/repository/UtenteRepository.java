package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.UtenteDto;
import it.unicam.cs.model.Utente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.List;


public interface UtenteRepository extends JpaRepository<Utente,Integer> {
    Utente findByUsername(String username);

    @Transactional
    default UtenteDto convertiUtenteinDto(Utente utente) {
        Comune comune = utente.getComuneAssociato();
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setId(utente.getId());
        utenteDto.setNome(utente.getNome());
        utenteDto.setUsername(utente.getUsername());
        utenteDto.setComuneAssociato(comune != null ? comune.getNome() : null);
        utenteDto.setCognome(utente.getCognome());
        utenteDto.setEmail(utente.getEmail());
        return utenteDto;
    }

    @Query(value = "SELECT u from Utente u JOIN u.poiCreati i WHERE i.id = :idRichiesta")
    Utente findByPOIid(@Param("idRichiesta") Integer idRichiesta);

    @Query(value = "SELECT u from Utente u JOIN u.itinerariCreati i WHERE i.id = :idRichiesta")
    Utente findByIitinerarioId(@Param("idRichiesta")Integer idRichiesta);

    @Query(value = "SELECT u from Utente u JOIN u.eventiCreati i WHERE i.id = :idRichiesta")
    Utente findByEventoId(@Param("idRichiesta")Integer idRichiesta);

    @Query(value = "SELECT u from Utente u JOIN u.contenutiMultimediali c WHERE c.id = :idRichiesta")
    Utente findByContenutoMultimedialeId(@Param("idRichiesta")Integer idRichiesta);

    @Query(value = "SELECT u from Utente u JOIN u.contenutoContestCreati c WHERE c.id = :idRichiesta")
    Utente findByContenutoContest(@Param("idRichiesta")Integer idRichiesta);

    @Query(value = "SELECT u from Utente u JOIN u.contestCreati c WHERE c.id = :idRichiesta")
    Utente findByContestCreatiId(@Param("idRichiesta")Integer idRichiesta);

    @Query(value = "SELECT u FROM Utente u JOIN u.contestInPartecipazione c WHERE c.id = :idRichiesta")
    List<Utente> findByContestinPartecipazioneId(@Param("idRichiesta")Integer idRichiesta);
    @Query(value = "SELECT u from Utente u JOIN u.ruoli r WHERE r.nome = :ruolo AND u.comuneAssociato.id = :id")
    Collection<Utente> findByRuoli_NomeAndComuneAssociato_Nome(String ruolo, int id);
    @Query(value= "SELECT u from Utente u WHERE u.comuneAssociato.nome = :comune")
    Collection<Utente> findByComuneAssociato(String comune);

}

