package it.unicam.cs.Builder.EVENTOBUILDER;

import it.unicam.cs.Visitor.Evento.IEventoBuilderVisitor;
import it.unicam.cs.Visitor.Evento.IEventoDtoVisitor;
import it.unicam.cs.model.DTO.EventoAmministrativoDto;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.EventoAmministrativo;
import it.unicam.cs.util.enums.TipoAmministrativo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
                super.getDescrizione(),super.getContributore(),super.getPoiAssociato(),
                super.getDataInizio(),super.getDataFine(), super.getContenutiMultimediali(), tipo, responsabile);
    }

    @Override
    public void accept(IEventoBuilderVisitor eventoBuilderVisitor, EventoDto eventoDto) {
        eventoBuilderVisitor.visit(this,(EventoAmministrativoDto) eventoDto);
    }
}
