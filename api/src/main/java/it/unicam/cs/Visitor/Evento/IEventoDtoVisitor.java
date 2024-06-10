package it.unicam.cs.Visitor.Evento;

import it.unicam.cs.model.DTO.input.EventoAmministrativoDto;
import it.unicam.cs.model.DTO.input.EventoIntrattenimentoDto;
import it.unicam.cs.model.DTO.input.EventoTuristicoDto;

public interface IEventoDtoVisitor {
    void visit (EventoAmministrativoDto eventoAmministrativoDto);
    void visit (EventoIntrattenimentoDto eventoIntrattenimentoDto);
    void visit (EventoTuristicoDto eventoTuristicoDto);
}
