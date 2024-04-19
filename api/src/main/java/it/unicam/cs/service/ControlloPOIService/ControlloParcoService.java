package it.unicam.cs.service.ControlloPOIService;

import it.unicam.cs.model.DTO.ParcoDto;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor @NoArgsConstructor
public class ControlloParcoService {
    private ValidationPOIExtension validationPOIExtension;

    public void controllaParco(ParcoDto parcoDto){
        validationPOIExtension.isOrariAperturaValido(parcoDto.getOrarioApertura());
        validationPOIExtension.isEstensioneValida(parcoDto.getEstensione());
    }
}
