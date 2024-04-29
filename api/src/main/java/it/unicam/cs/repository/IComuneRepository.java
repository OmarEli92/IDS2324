package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.ComuneDTO;
import it.unicam.cs.model.DTO.UtenteDto;
import it.unicam.cs.model.Utente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComuneRepository extends JpaRepository<Comune,Integer> {
    Comune findByNome(String nome);


    default ComuneDTO convertiComuneinDto(Comune comune){
        ComuneDTO comuneDTO = new ComuneDTO();
        comuneDTO.setId(comune.getId());
        comuneDTO.setNome(comune.getNome());
        return comuneDTO;
    }
}
