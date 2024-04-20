package it.unicam.cs.service.ControlloPOIService;

import it.unicam.cs.exception.POI.TipoAmministrativoNotValidException;
import it.unicam.cs.model.DTO.PoiAmministrativoDto;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import it.unicam.cs.util.enums.TipoAmministrativo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlloPOIAmministrativoService {
    @Autowired
    private ValidationPOIExtension validationExtension;

    public void controllaPoiSpecifico(PoiDto poiDto){
        PoiAmministrativoDto poiAmministrativoDto = (PoiAmministrativoDto) poiDto;
        controllaTipoAmministrativo(poiAmministrativoDto.getTipo());
        validationExtension.isOrariAperturaValido(poiAmministrativoDto.getOrariApertura());
        validationExtension.isResponsabileValido(poiAmministrativoDto.getResponsabile());
        validationExtension.areContattiValidi(poiAmministrativoDto.getContatti());
    }

    private void controllaTipoAmministrativo(String tipo) {
        TipoAmministrativo[] tipi = TipoAmministrativo.values();
        for (TipoAmministrativo t : tipi){
            if(tipo.equalsIgnoreCase(t.name()))
                return;
        }
        throw new TipoAmministrativoNotValidException();
    }

}
