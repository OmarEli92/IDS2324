package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.ComuneDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.service.ComuneService;
import it.unicam.cs.service.ControlloService.ControlloComuneService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.info.Posizione;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CaricamentoComuneService {
    private ComuneService comuneService;
    private UtenteService utenteService;
    private ControlloComuneService controlloComuneService;

    public void caricaComune(ComuneDto comuneDto){
        controlloComuneService.verificaComune(comuneDto);
        costrusciComune(comuneDto);
    }

    private void costrusciComune(ComuneDto comuneDto) {
        String nome = comuneDto.getNome();
        List<Posizione> territorio = comuneDto.getTerritorio();
        Utente gestoreComune = utenteService.ottieniUtenteById(comuneDto.getIdGestore());
        Comune comune = new Comune(nome,gestoreComune);
    }

}
