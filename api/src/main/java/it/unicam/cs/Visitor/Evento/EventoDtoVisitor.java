package it.unicam.cs.Visitor.Evento;

import it.unicam.cs.exception.Contenuto.ServiziNotValidException;
import it.unicam.cs.exception.Contenuto.TipoAmministrativoNotValidException;
import it.unicam.cs.exception.Contenuto.TipoIntrattenimentoNotValidException;
import it.unicam.cs.exception.Contenuto.TipoTuristicoNotValidException;
import it.unicam.cs.model.DTO.input.EventoAmministrativoDto;
import it.unicam.cs.model.DTO.input.EventoIntrattenimentoDto;
import it.unicam.cs.model.DTO.input.EventoTuristicoDto;
import it.unicam.cs.util.Extensions.ValidationEventoExtension;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.enums.TipoAmministrativo;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import it.unicam.cs.util.enums.TipoTuristico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventoDtoVisitor implements IEventoDtoVisitor{
    @Autowired
    private ValidationEventoExtension validationEventoExtension;
    @Override
    public void visit(EventoAmministrativoDto eventoAmministrativoDto) {
        controllaTipoAmministrativo(eventoAmministrativoDto.getTipo());
        validationEventoExtension.isResponsabileValido(eventoAmministrativoDto.getResponsabile());
    }

    private void controllaTipoAmministrativo(String tipo) {
        TipoAmministrativo[] tipi = TipoAmministrativo.values();
        for (TipoAmministrativo t : tipi){
            if(tipo.equalsIgnoreCase(t.name()))
                return;
        }
        throw new TipoAmministrativoNotValidException();
    }


    @Override
    public void visit(EventoIntrattenimentoDto eventoIntrattenimentoDto) {
        controllaTipoIntrattenimento(eventoIntrattenimentoDto.getTipo());
        validationEventoExtension.isEtaConsigliatiValida(eventoIntrattenimentoDto.getEtaConsigliata());
        controllaServiziIntrattenimento(eventoIntrattenimentoDto.getServiziOfferti());
    }

    private void controllaTipoIntrattenimento(String tipo) {
        TipoIntrattenimento[] tipi = TipoIntrattenimento.values();
        for (TipoIntrattenimento t : tipi){
            if(tipo.equalsIgnoreCase(t.name()))
                return;
        }
        throw new TipoIntrattenimentoNotValidException();
    }
    private void controllaServiziIntrattenimento(List<String> serviziOfferti) {
        boolean valid = serviziOfferti.stream().allMatch(value -> contieneValoreServizio(Servizio.class, value));
        if(!valid){
            throw new ServiziNotValidException();
        }
    }
    private <T extends Enum<T>> boolean contieneValoreServizio(Class<T> servizioClass, String name) {
        Servizio servizio = Enum.valueOf(Servizio.class, name.toUpperCase());
        if(servizio == null){
            return false;
        }
        return  true;
    }

    @Override
    public void visit(EventoTuristicoDto eventoTuristicoDto) {
        controllaTipoTuristico(eventoTuristicoDto.getTipo());
    }

    private void controllaTipoTuristico(String tipo) {
        TipoTuristico[] tipiTuristici = TipoTuristico.values();
        for(TipoTuristico t : tipiTuristici){
            if(tipo.equalsIgnoreCase(t.name())){
                return;
            }
        }
        throw new TipoTuristicoNotValidException();
    }
}
