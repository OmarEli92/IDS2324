package it.unicam.cs.Visitor.Evento;

import it.unicam.cs.model.DTO.EventoAmministrativoDto;
import it.unicam.cs.model.DTO.EventoIntrattenimentoDto;
import it.unicam.cs.model.DTO.EventoTuristicoDto;

public interface IEventoDtoVisitor {
    void visit (EventoAmministrativoDto eventoAmministrativoDto);
    void visit (EventoIntrattenimentoDto eventoIntrattenimentoDto);
    void visit (EventoTuristicoDto eventoTuristicoDto);
}
