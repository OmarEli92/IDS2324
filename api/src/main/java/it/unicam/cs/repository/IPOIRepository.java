package it.unicam.cs.repository;

import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.abstractions.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPOIRepository extends JpaRepository<POI, Integer> {
        @Query(value= "SELECT p from POI p JOIN p.comuneAssociato c WHERE c.id = :comuneId")
        List<POI> findByComuneAssociatoId(@Param("comuneId") Integer comuneId);
        @Query(value = "SELECT p from POI p JOIN p.eventiAssociati e where e.id = :idRichiesta")
        POI findPOIByIdEvento(@Param("idRichiesta")Integer idRichiesta);
        @Query(value = "SELECT p from POI p JOIN p.contenutiMultimediali c where c.id = :idRichiesta")
        POI findByIdContenutoMultimediale(@Param("idRichiesta")Integer idRichiesta);
        @Query(value = "SELECT p from POI p JOIN p.contestAssociati c WHERE c.id = :idRichiesta")
        POI findByIdContest(@Param("idRichiesta")Integer idRichiesta);
        @Query("SELECT p FROM POI p WHERE p.posizione.latitudine = :latitudine AND p.posizione.longitudine = :longitudine AND p.comuneAssociato.id = :comuneId")
        List<POI> findByPosizioneAndComune(@Param("latitudine") double latitudine, @Param("longitudine") double longitudine, @Param("comuneId") int comuneId);
        /*default PoiDto convertiPOIinPoiDto(POI poi){
                PoiDto poiDTO = new PoiDto();
                poiDTO.setID(poi.getId());
                poiDTO.setNome(poi.getNome());
                poiDTO.setIDComune(poi.getComuneAssociato() != null?poi.getComuneAssociato().getId():null);
                poiDTO.setPosizione(poi.getPosizione());
                poiDTO.setIDContributore(poi.getContributore() != null ?poi.getContributore().getId():null);
                return poiDTO;
    }*/
}
