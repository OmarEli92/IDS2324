package it.unicam.cs.Visitor.Evento;

import it.unicam.cs.Builder.EVENTOBUILDER.EventoAmministrativoBuilder;
import it.unicam.cs.Builder.EVENTOBUILDER.EventoIntrattenimentoBuilder;
import it.unicam.cs.Builder.EVENTOBUILDER.EventoTuristicoBuilder;
import it.unicam.cs.model.DTO.input.EventoAmministrativoDto;
import it.unicam.cs.model.DTO.input.EventoIntrattenimentoDto;
import it.unicam.cs.model.DTO.input.EventoTuristicoDto;

public interface IEventoBuilderVisitor {
    void visit(EventoIntrattenimentoBuilder eventoIntrattenimentoBuilder, EventoIntrattenimentoDto eventoIntrattenimentoDto);
    void visit(EventoAmministrativoBuilder eventoAmministrativoBuilder, EventoAmministrativoDto eventoAmministrativoDto);
    void visit(EventoTuristicoBuilder eventoTuristicoBuilder, EventoTuristicoDto eventoTuristicoDto);
}
