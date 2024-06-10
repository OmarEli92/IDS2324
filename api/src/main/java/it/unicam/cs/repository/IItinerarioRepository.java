package it.unicam.cs.repository;



import it.unicam.cs.model.DTO.input.ItinerarioDto;
import it.unicam.cs.model.contenuti.Itinerario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IItinerarioRepository extends JpaRepository<Itinerario, Integer> {

    @Query(value= "SELECT i from Itinerario i WHERE i.comuneAssociato.id  = :comuneId")
    List<Itinerario> findByComuneAssociatoId(@Param("comuneId") Integer comuneId);
    @Query(value = "SELECT i from Itinerario i JOIN i.contenutiMultimedialiAssociati c WHERE c.id = :idRichiesta")
    Itinerario findItinerarioByContenutoMultimedialeId(@Param("idRichiesta") Integer idRichiesta);
    /*default ItinerarioDto convertiItinerarioAItinerarioDto(Itinerario itinerario){
        ItinerarioDto itinerarioDto = new ItinerarioDto();
        itinerarioDto.setID(itinerario.getId());
        itinerarioDto.setDescrizione(itinerario.getDescirizione());
        itinerarioDto.setNome(itinerario.getNome());
        itinerarioDto.setIDContributore(itinerario.getContributore()!= null ? itinerario.getContributore().getId():null);
        itinerarioDto.setIDComune(itinerario.getComuneAssociato() != null? itinerario.getComuneAssociato().getId():null);
        return itinerarioDto;
    }*/

}
