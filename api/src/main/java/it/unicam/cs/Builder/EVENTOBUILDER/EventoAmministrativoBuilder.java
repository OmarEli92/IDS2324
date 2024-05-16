package it.unicam.cs.Builder.EVENTOBUILDER;

import it.unicam.cs.Visitor.Evento.IEventoBuilderVisitor;
import it.unicam.cs.model.DTO.input.EventoAmministrativoDto;
import it.unicam.cs.model.DTO.input.EventoDto;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.EventoAmministrativo;
import it.unicam.cs.util.enums.TipoAmministrativo;
import it.unicam.cs.util.enums.TipoEvento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor @NoArgsConstructor
public class EventoAmministrativoBuilder extends EventoBuilder{
    private TipoAmministrativo tipo;
    private String responsabile;

    public void setTipo(TipoAmministrativo tipo) {
        this.tipo = tipo;
    }

    public void setResponsabile(String responsabile) {
        this.responsabile = responsabile;
    }

    @Override
    public Evento build() {
        return new EventoAmministrativo(super.getComuneAssociato(),super.getNome(),
                super.getDescrizione(), super.isAttivo(), TipoEvento.AMMINISTRATIVO,super.getContributore(),super.getStato(),super.getPoiAssociato(),
                super.getDataInizio(),super.getDataFine(), super.getContenutiMultimediali(), tipo, responsabile);
    }

    @Override
    public void accept(IEventoBuilderVisitor eventoBuilderVisitor, EventoDto eventoDto) {
        eventoBuilderVisitor.visit(this,(EventoAmministrativoDto) eventoDto);
    }
}
