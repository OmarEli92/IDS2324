package it.unicam.cs.Visitor.Evento;

import it.unicam.cs.Builder.EVENTOBUILDER.EventoAmministrativoBuilder;
import it.unicam.cs.Builder.EVENTOBUILDER.EventoIntrattenimentoBuilder;
import it.unicam.cs.Builder.EVENTOBUILDER.EventoTuristicoBuilder;
import it.unicam.cs.model.DTO.EventoAmministrativoDto;
import it.unicam.cs.model.DTO.EventoIntrattenimentoDto;
import it.unicam.cs.model.DTO.EventoTuristicoDto;

public class EventoBuilderVisitor implements IEventoBuilderVisitor{
    @Override
    public void visit(EventoIntrattenimentoBuilder eventoIntrattenimentoBuilder, EventoIntrattenimentoDto eventoIntrattenimentoDto) {

    }

    @Override
    public void visit(EventoAmministrativoBuilder eventoAmministrativoBuilder, EventoAmministrativoDto eventoAmministrativoDto) {

    }

    @Override
    public void visit(EventoTuristicoBuilder eventoTuristicoBuilder, EventoTuristicoDto eventoTuristicoDto) {

    }
}
