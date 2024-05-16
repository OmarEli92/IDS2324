package it.unicam.cs.service.ControlloService;

import it.unicam.cs.model.DTO.input.ComuneDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ControlloComuneService {

    public void verificaComune(ComuneDto comuneDto){
        verificaNome(comuneDto.getNome());
    }

    private void verificaNome(String string) {
        if(string != null) {
            if (string.trim().length() < 3 && string.trim().length() > 20) {
                throw new IllegalArgumentException("lunghezza responsabile non corretta");
            }
            Pattern pattern = Pattern.compile("[^a-zA-Z0-9]+");
            boolean valid = pattern.matcher(string).matches();
            if (!valid) {
                throw new IllegalArgumentException("il nome del comune non può avere caratteri speciali");
            }
        }
    }
}
