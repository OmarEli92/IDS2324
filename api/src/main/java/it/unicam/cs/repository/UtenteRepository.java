package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.DTO.UtenteDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
