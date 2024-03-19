package it.unicam.cs.controller;

import it.unicam.cs.security.AuthenticationService;
import it.unicam.cs.security.request.AuthenticationRequest;
import it.unicam.cs.security.request.RegisterRequest;
import it.unicam.cs.security.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor
@RequestMapping(value = "api/auth")
public class ControllerAutenticazione {
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/registrazione")
    public ResponseEntity<AuthenticationResponse> registrazione(@RequestBody RegisterRequest request){
        return new ResponseEntity<AuthenticationResponse>(authenticationService.registraUtente(request), HttpStatus.CREATED);
    }
    @PostMapping(value = "/login")
    public ResponseEntity<AuthenticationResponse> autenticazione(@RequestBody AuthenticationRequest request){
        return new ResponseEntity<AuthenticationResponse>(authenticationService.autenticazione(request),HttpStatus.OK);
    }
}
