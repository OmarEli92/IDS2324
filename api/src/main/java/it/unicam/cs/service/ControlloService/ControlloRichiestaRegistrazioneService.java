package it.unicam.cs.service.ControlloService;

import it.unicam.cs.security.request.RegisterRequest;
import it.unicam.cs.util.Match;
import org.springframework.stereotype.Service;

@Service
public class ControlloRichiestaRegistrazioneService {

    public void verificaRichiestaRegistrazione (RegisterRequest request){
        controllaNome(request.getNome());
        controllaCognome(request.getCognome());
        controllaEmail(request.getEmail());
        controllaPassword(request.getPassword());
        controllaTelefono(request.getTelefono());
        controllaSesso(request.getSesso());
    }

    private void controllaSesso(String sesso) {
        if(!Match.isSesso(sesso)){
            throw new IllegalArgumentException("il sesso deve essere maschio o femmina");
        }
    }

    private void controllaTelefono(String telefono) {
        if(!Match.isNumeroDiTelefono(telefono)){
            throw new IllegalArgumentException("numero di telefono non valido");
        }
    }

    private void controllaPassword(String password) {
        if(!Match.isPassword(password)){
            throw new IllegalArgumentException("password non valida");
        }
    }

    private void controllaEmail(String email) {
        if (!Match.isEmail(email)){
            throw new IllegalArgumentException("la stringa inserita non è un'email");
        }
    }

    private void controllaCognome(String cognome) {
        if(!Match.contieneSoloLettere(cognome)){
            throw new IllegalArgumentException("il cognome può contenere solo lettere");
        }
    }

    private void controllaNome(String nome) {
        if(!Match.contieneSoloLettere(nome)){
            throw new IllegalArgumentException("il nome può contenere solo lettere");
        }
    }
}
