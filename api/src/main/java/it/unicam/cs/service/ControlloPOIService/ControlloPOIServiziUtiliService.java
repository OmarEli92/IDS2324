package it.unicam.cs.service.ControlloPOIService;

import it.unicam.cs.exception.POI.ServiziUtiliNotValidException;
import it.unicam.cs.model.DTO.PoiServiziUtiliDto;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import it.unicam.cs.util.enums.ServiziUtili;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ControlloPOIServiziUtiliService {
    private ValidationPOIExtension validationPOIExtension;

    public void controllaPOIServiziUtili(PoiServiziUtiliDto poiServiziUtiliDto){
        controllaServiziUtili(poiServiziUtiliDto.getServizio());
        validationPOIExtension.areContattiValidi(poiServiziUtiliDto.getContatti());
        validationPOIExtension.isOrariAperturaValido(poiServiziUtiliDto.getOrariApertura());
    }

    private void controllaServiziUtili(String servizio) {
        ServiziUtili[] servizi = ServiziUtili.values();
        for (ServiziUtili s : servizi){
            if(servizio.equalsIgnoreCase(s.name())){
                return;
            }
        }
        throw new ServiziUtiliNotValidException();
    }
}
