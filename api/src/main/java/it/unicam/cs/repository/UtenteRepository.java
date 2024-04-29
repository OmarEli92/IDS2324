package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.DTO.UtenteDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface UtenteRepository extends JpaRepository<Utente,Integer> {
    Utente findByUsername(String username);
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
    @Query(value = "SELECT u from Utente u JOIN u.ruoli r WHERE r.nome = :ruolo AND u.comuneAssociato.id = :id")
    Collection<Utente> findByRuoli_NomeAndComuneAssociato_Nome(String ruolo, int id);
    @Query(value= "SELECT u from Utente u WHERE u.comuneAssociato.nome = :comune")
    Collection<Utente> findByComuneAssociato(String comune);
}
