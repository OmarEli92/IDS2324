package it.unicam.cs.Builder.EVENTOBUILDER;

import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.EventoIntrattimento;
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
    private List<ContenutoMultimediale> contenutiMultimediali;

    public void setTipo(TipoIntrattenimento tipo) {
        this.tipo = tipo;
    }

    public void setContenutiMultimediali(List<ContenutoMultimediale> contenutiMultimediali) {
        this.contenutiMultimediali = contenutiMultimediali;
    }

    @Override
    public Evento build() {
        return new EventoIntrattimento(super.getId(),super.getComuneAssociato(),super.getNome(),super.getDescrizione(),
                super.getContributore(),super.getPoiAssociato(),super.getDataInizio(),super.getDataFine(),tipo,contenutiMultimediali);
    }
}
