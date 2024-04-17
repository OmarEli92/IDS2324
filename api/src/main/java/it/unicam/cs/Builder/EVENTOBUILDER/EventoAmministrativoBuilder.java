package it.unicam.cs.Builder.EVENTOBUILDER;

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
    private List<ContenutoMultimediale> contenutiMultimediale;

    public void setTipo(TipoAmministrativo tipo) {
        this.tipo = tipo;
    }

    public void setContenutiMultimediale(List<ContenutoMultimediale> contenutiMultimediale) {
        this.contenutiMultimediale = contenutiMultimediale;
    }

    @Override
    public Evento build() {
        return new EventoAmministrativo(super.getId(),super.getComuneAssociato(),super.getNome(),
                super.getDescrizione(),super.getContributore(),super.getPoiAssociato(),
                super.getDataInizio(),super.getDataFine(),tipo,contenutiMultimediale);
    }
}
