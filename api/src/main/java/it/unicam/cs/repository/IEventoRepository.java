package it.unicam.cs.repository;

import it.unicam.cs.model.DTO.input.EventoDto;
import it.unicam.cs.model.abstractions.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

/** L'interfaccia EventoRepository è un repository che gestisce la persistenza dei dati relativi agli eventi
 * nella piattaforma e fornisce metodi adibiti a tale scopo **/
public interface IEventoRepository extends JpaRepository<Evento,Integer> {
    Evento findEventoById(Integer id);
    @Query(value= "SELECT e from Evento e WHERE e.comuneAssociato.id  = :comuneId")
    List<Evento> findByComuneAssociatoId(Integer comuneId);
    @Query(value = "SELECT e from Evento e JOIN e.contenutiMultimediali c WHERE c.id =: idRichiesta")
    Evento findEventoByContenutoMultimedialeId(Integer idRichiesta);
    List<Evento> findByDataInizioBeforeAndApertoIsFalse(LocalDateTime localDateTime);
    List<Evento> findByDataFineBeforeAndApertoIsTrue(LocalDateTime localDateTime);
    default EventoDto convertiEventoInEventoDTO(Evento evento){
        EventoDto eventoDto = new EventoDto();
        eventoDto.setID(evento.getId());
        eventoDto.setNome(evento.getNome());
        eventoDto.setDescrizione(evento.getDescrizione());
        eventoDto.setPosizione(evento.getPoiAssociato().getPosizione());
        eventoDto.setIDContributore(evento.getContributore() != null ?evento.getContributore().getId() :null);
        eventoDto.setIDComune(evento.getComuneAssociato() != null ? evento.getComuneAssociato().getId() :null);
        return eventoDto;
    }
}
