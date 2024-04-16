package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ApiModel("dto per evento turistico")
public class EventoTuristicoDto extends EventoDto{
}
