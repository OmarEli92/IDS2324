package it.unicam.cs.security;

import io.jsonwebtoken.Jwt;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.IComuneRepository;
import it.unicam.cs.repository.ITokenRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.security.request.AuthenticationRequest;
import it.unicam.cs.security.request.RegisterRequest;
import it.unicam.cs.security.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor @Slf4j
public class AuthenticationService {
    private final UtenteRepository utenteRepository;
    private final JwtService  jwtService;
    private final AuthenticationManager authenticationManager;
    private final IComuneRepository comuneRepository;
    private final PasswordEncoder passwordEncoder;
    private final ITokenRepository tokenRepository;

    /** Registra un utente nel db**/
    public AuthenticationResponse registraUtente(RegisterRequest request){
        Comune comuneAssociato = comuneRepository.findByNome(request.getComuneAssociato());
        if(comuneAssociato == null){
            throw new NullPointerException("Il comune associato all'utente non è presente!");
        }
        var utente = Utente.builder()
                .nome(request.getNome())
                .cognome(request.getCognome())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .telefono(request.getTelefono())
                .comuneAssociato(comuneAssociato)
                .dataDiNascita(request.getDataDiNascita())
                .sesso(request.getSesso())
                .build();
        utenteRepository.save(utente);
        log.info("Aggiunto l'utente {} nel db",utente.getUsername());
        var jwtToken = jwtService.generaToken(utente);
        salvaTokenUtente(jwtToken,utente);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    /** Metodo per l'autenticazione**/
    public AuthenticationResponse autenticazione(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword())
        );
        log.info("tentativo di login");
        var utente = utenteRepository.findByUsername(request.getUsername());
        var jwtToken = jwtService.generaToken(utente);
        rimuoviTokenAssociatiAUtente(utente);
        salvaTokenUtente(jwtToken,utente);
        log.info("L'utente {} ha effettuato il login", utente.getUsername());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void salvaTokenUtente(String jwt, Utente utente){
        Token token = new Token();
        token.setToken(jwt);
        token.setUtente(utente);
        token.setLoggedOut(false);
        tokenRepository.save(token);
    }

    private void rimuoviTokenAssociatiAUtente(Utente utente){
        List<Token> tokenAssociati = tokenRepository.findAllTokenByUtente(utente.getId());
        if(!tokenAssociati.isEmpty()){
            tokenAssociati.forEach(token -> token.setLoggedOut(true));
        }
        tokenRepository.saveAll(tokenAssociati);
    }
}
