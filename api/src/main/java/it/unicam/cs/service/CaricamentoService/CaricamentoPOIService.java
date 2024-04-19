package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Factory.POIBuilderFactory;
import it.unicam.cs.model.DTO.PoiAmministrativoDto;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.ControlloPOIService.ControlloPOIAmministrativoService;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CaricamentoPOIService {
    private final UtenteRepository utenteRepository;
    private final ValidationPOIExtension validationPOIExtension;
    private final POIBuilderFactory poiBuilderFactory;
    private final ControlloPOIAmministrativoService controlloPOIAmministrativoService;

    public void caricaPOI(PoiDto poiDto){
        verificaPOI(poiDto);
    }

    private void verificaPOI(PoiDto poiDto) {
        validationPOIExtension.isPOINomeValid(poiDto.getNome());
        validationPOIExtension.isPOIContributoreValid(poiDto.getIDContributore());
        if(poiDto instanceof PoiAmministrativoDto){
            controlloPOIAmministrativoService.controllaPoiAmministrativo((PoiAmministrativoDto) poiDto);
        }

    }

}
