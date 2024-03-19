package it.unicam.cs.repository;

import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/** L'interfaccia EventoRepository è un repository che gestisce la persistenza dei dati relativi agli eventi
 * nella piattaforma e fornisce metodi adibiti a tale scopo **/
public interface IEventoRepository extends JpaRepository<Evento,Integer> {

    @Query(value= "SELECT e from Evento e WHERE e.comuneAssociato.id  = :comuneId")
    List<Evento> findByComuneAssociatoId(Integer comuneId);

    default EventoDto convertiEventoInEventoDTO(Evento evento){
        EventoDto eventoDto = new EventoDto();
        eventoDto.setID(evento.getId());
        eventoDto.setNome(evento.getNome());
        eventoDto.setDescrizione(evento.getDescrizione());
        eventoDto.setPosizione(evento.getPoiAssociato().getPosizione());
        eventoDto.setTipo(evento.getTipo());
        eventoDto.setIDContributore(evento.getContributore() != null ?evento.getContributore().getId() :null);
        eventoDto.setIDComune(evento.getComuneAssociato() != null ? evento.getComuneAssociato().getId() :null);
        return eventoDto;
    }
}
