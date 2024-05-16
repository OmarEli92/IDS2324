package it.unicam.cs.repository;

import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.abstractions.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPOIRepository extends JpaRepository<POI, Integer> {
        POI findPoiById(Integer id);
        @Query(value= "SELECT p from POI p WHERE p.comuneAssociato.id = :comuneId")
        List<POI> findByComuneAssociatoId(Integer comuneId);
        @Query(value = "SELECT p from POI p JOIN p.eventiAssociati e where e.id =: richiestaId")
        POI findPOIByIdEvento(Integer idRichiesta);
        @Query(value = "SELECT p from POI p JOIN p.contenutiMultimediali c where c.id =: idRichiesta")
        POI findByIdContenutoMultimediale(Integer idRichiesta);
        @Query(value = "SELECT from POI p JOIN p.contestAssociati c WHERE c.id =: idRichiesta")
        POI findByIdContest(Integer idRichiesta);
        default PoiDto convertiPOIinPoiDto(POI poi){
                PoiDto poiDTO = new PoiDto();
                poiDTO.setID(poi.getId());
                poiDTO.setNome(poi.getNome());
                poiDTO.setIDComune(poi.getComuneAssociato() != null?poi.getComuneAssociato().getId():null);
                poiDTO.setPosizione(poi.getPosizione());
                poiDTO.setIDContributore(poi.getContributore() != null ?poi.getContributore().getId():null);
                return poiDTO;
    }
}
