package it.unicam.cs.Visitor.Evento;

import it.unicam.cs.Builder.EVENTOBUILDER.EventoAmministrativoBuilder;
import it.unicam.cs.Builder.EVENTOBUILDER.EventoIntrattenimentoBuilder;
import it.unicam.cs.Builder.EVENTOBUILDER.EventoTuristicoBuilder;
import it.unicam.cs.model.DTO.input.EventoAmministrativoDto;
import it.unicam.cs.model.DTO.input.EventoIntrattenimentoDto;
import it.unicam.cs.model.DTO.input.EventoTuristicoDto;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.enums.TipoAmministrativo;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import it.unicam.cs.util.enums.TipoTuristico;

import java.util.stream.Collectors;

public class EventoBuilderVisitor implements IEventoBuilderVisitor{
    @Override
    public void visit(EventoIntrattenimentoBuilder eventoIntrattenimentoBuilder, EventoIntrattenimentoDto eventoIntrattenimentoDto) {
        eventoIntrattenimentoBuilder.setTipo(TipoIntrattenimento.valueOf(eventoIntrattenimentoDto.getTipo().toUpperCase()));
        eventoIntrattenimentoBuilder.setEtaConsigliata(eventoIntrattenimentoDto.getEtaConsigliata());
        eventoIntrattenimentoBuilder.setServiziOfferti(eventoIntrattenimentoDto.getServiziOfferti().stream()
                .map(Servizio :: valueOf)
                .collect(Collectors.toList()));
    }

    @Override
    public void visit(EventoAmministrativoBuilder eventoAmministrativoBuilder, EventoAmministrativoDto eventoAmministrativoDto) {
        eventoAmministrativoBuilder.setTipo(TipoAmministrativo.valueOf(eventoAmministrativoDto.getTipo().toUpperCase()));
        eventoAmministrativoBuilder.setResponsabile(eventoAmministrativoDto.getResponsabile());
    }

    @Override
    public void visit(EventoTuristicoBuilder eventoTuristicoBuilder, EventoTuristicoDto eventoTuristicoDto) {
        eventoTuristicoBuilder.setTipo(TipoTuristico.valueOf(eventoTuristicoDto.getTipo().toUpperCase()));
    }
}
