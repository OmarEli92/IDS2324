package it.unicam.cs.repository;

import it.unicam.cs.model.abstractions.Evento;
import org.springframework.data.repository.CrudRepository;

/** L'interfaccia EventoRepository è un repository che gestisce la persistenza dei dati relativi agli eventi
 * nella piattaforma e fornisce metodi adibiti a tale scopo **/
public interface IEventoRepository extends CrudRepository<Evento,Integer> {


}
