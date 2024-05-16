package it.unicam.cs.model.DTO.input;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
@Data
public class ContestDto {
    private Integer id;
    private String descrizione;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private int partecipanti;
    private Integer idPoiAssociato;
    private Integer idOrganizzatore;
    private String tipoInvito;
}
