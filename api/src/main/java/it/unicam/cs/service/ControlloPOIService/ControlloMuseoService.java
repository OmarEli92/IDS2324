package it.unicam.cs.service.ControlloPOIService;

import it.unicam.cs.model.DTO.MuseoDto;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import it.unicam.cs.util.enums.CollezioniMuseo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlloMuseoService extends ControlloPOIService{
    @Autowired
    private ValidationPOIExtension validationPOIExtension;

    public void controllaPOISpecifico(PoiDto poiDto){
        MuseoDto museoDto = (MuseoDto) poiDto;
        validationPOIExtension.isOrariAperturaValido(museoDto.getOrariApertura());
        validationPOIExtension.isResponsabileValido(museoDto.getResponsabile());
        validationPOIExtension.areContattiValidi(museoDto.getContatti());
        validationPOIExtension.isNumeroSaleValid(museoDto.getNumeroSale());
        controllaCollezioni(museoDto.getCollezioni());
    }

    private void controllaCollezioni(List<String> collezioni) {
        boolean valid = collezioni.stream().allMatch(value -> contieneValoreEnum(CollezioniMuseo.class,value));
    }

    private <T extends Enum<T>> boolean contieneValoreEnum(Class<T> collezioniMuseoClass, String value) {
        CollezioniMuseo collezione = Enum.valueOf(CollezioniMuseo.class,value.toUpperCase());
        if(collezione == null){
            return false;
        }
        return true;
    }
}
