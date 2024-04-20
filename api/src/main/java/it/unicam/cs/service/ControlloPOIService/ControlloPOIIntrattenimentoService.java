package it.unicam.cs.service.ControlloPOIService;

import it.unicam.cs.exception.POI.ServiziNotValidException;
import it.unicam.cs.exception.POI.TipoAmministrativoNotValidException;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.DTO.PoiIntrattenimentoDto;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.enums.TipoAmministrativo;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.List;

@Service
public class ControlloPOIIntrattenimentoService extends ControlloPOIService {
    @Autowired
    private ValidationPOIExtension validationPOIExtension;

    public void controllaPOISpecifico(PoiDto poiDto){
        PoiIntrattenimentoDto poiIntrattenimentoDto = (PoiIntrattenimentoDto)poiDto;
        controllaTipoIntrattenimento(poiIntrattenimentoDto.getTipo());
        validationPOIExtension.isEtaConsigliatiValida(poiIntrattenimentoDto.getEtaConsigliata());
        validationPOIExtension.isOrariAperturaValido(poiIntrattenimentoDto.getOrariApertura());
        validationPOIExtension.areContattiValidi(poiIntrattenimentoDto.getContatti());
        controllaServiziIntrattenimento(poiIntrattenimentoDto.getServiziOfferti());
    }

    private void controllaServiziIntrattenimento(List<String> serviziOfferti) {
        boolean valid = serviziOfferti.stream().allMatch(value -> contieneValoreEnum(Servizio.class, value));
        if(!valid){
            throw new ServiziNotValidException();
        }
    }

    private <T extends Enum<T>> boolean contieneValoreEnum(Class<T> servizioClass, String name) {
        Servizio servizio = Enum.valueOf(Servizio.class, name.toUpperCase());
        if(servizio == null){
            return false;
        }
        return  true;
    }


    private void controllaTipoIntrattenimento(String tipo) {
        TipoIntrattenimento[] tipi = TipoIntrattenimento.values();
        for (TipoIntrattenimento t : tipi){
            if(tipo.equalsIgnoreCase(t.name()))
                return;
        }
        throw new TipoAmministrativoNotValidException();
    }
}
