package it.unicam.cs.service.ControlloPOIService;

import it.unicam.cs.exception.POI.TipoAmministrativoNotValidException;
import it.unicam.cs.model.DTO.PoiAmministrativoDto;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import it.unicam.cs.util.enums.TipoAmministrativo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor @NoArgsConstructor
public class ControlloPOIAmministrativoService {
    private ValidationPOIExtension validationExtension;

    public void controllaPoiAmministrativo(PoiAmministrativoDto poiDto){
        controllaTipoAmministrativo(poiDto.getTipo());
        validationExtension.isOrariAperturaValido(poiDto.getOrariApertura());
        validationExtension.isResponsabileValido(poiDto.getResponsabile());
        validationExtension.areContattiValidi(poiDto.getContatti());
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
