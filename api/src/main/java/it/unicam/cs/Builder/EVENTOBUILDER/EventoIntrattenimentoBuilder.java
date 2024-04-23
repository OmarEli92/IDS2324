package it.unicam.cs.Builder.EVENTOBUILDER;

import it.unicam.cs.Visitor.Evento.IEventoBuilderVisitor;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.DTO.EventoIntrattenimentoDto;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.EventoIntrattimento;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor @NoArgsConstructor
public class EventoIntrattenimentoBuilder extends EventoBuilder{
    private TipoIntrattenimento tipo;
    private int etaConsigliata;
    private List<Servizio> serviziOfferti;

    public void setTipo(TipoIntrattenimento tipo) {
        this.tipo = tipo;
    }

    public void setEtaConsigliata(int etaConsigliata) {
        this.etaConsigliata = etaConsigliata;
    }

    public void setServiziOfferti(List<Servizio> serviziOfferti) {
        this.serviziOfferti = serviziOfferti;
    }

    @Override
    public Evento build() {
        return new EventoIntrattimento(super.getComuneAssociato(),super.getNome(),super.getDescrizione(),
                super.getContributore(),super.getStato(),super.getPoiAssociato(),super.getDataInizio(),super.getDataFine(),super.getContenutiMultimediali(),tipo,
                etaConsigliata,serviziOfferti);
    }

    @Override
    public void accept(IEventoBuilderVisitor eventoBuilderVisitor, EventoDto eventoDto) {
        eventoBuilderVisitor.visit(this,(EventoIntrattenimentoDto) eventoDto);
    }
}
