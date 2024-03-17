package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.abstractions.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPOIRepository extends JpaRepository<POI, Integer> {
        @Query(value= "SELECT p from POI p WHERE p.comuneAssociato.id = :comuneId")
        List<POI> findByComuneAssociatoId(Integer comuneId);
        default PoiDto convertiPOIinPoiDto(POI poi){
                PoiDto poiDTO = new PoiDto();
                poiDTO.setID(poi.getId());
                poiDTO.setNome(poi.getNome());
                poiDTO.setIDComune(poi.getComuneAssociato() != null?poi.getComuneAssociato().getId():null);
                poiDTO.setPosizione(poi.getPosizione());
                poiDTO.setIDContributore(poi.getContributore() != null ?poi.getContributore().getId():null);
                poiDTO.setTipo(poi.getTipo());
                return poiDTO;
    }
}
