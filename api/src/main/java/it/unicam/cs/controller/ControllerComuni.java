package it.unicam.cs.controller;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.ListaComuni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerComuni {
    @Autowired
    private ListaComuni listaComuni;
    private Integer IDcomuneSelezionato;
    public ControllerComuni() {
    }
    @GetMapping(value="/comuni")
    public ResponseEntity<Object> selezionaComune(String nomeComune){
        if(listaComuni.getComune(nomeComune) != null){
            this.IDcomuneSelezionato = listaComuni.getComune(nomeComune).getId();
            return new ResponseEntity<>("Comune selezionato", HttpStatus.OK);
        }
        return new ResponseEntity<>("Comune non trovato!", HttpStatus.BAD_REQUEST);
    }
}
