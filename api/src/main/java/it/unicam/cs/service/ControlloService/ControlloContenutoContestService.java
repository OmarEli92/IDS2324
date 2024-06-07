package it.unicam.cs.service.ControlloService;

import it.unicam.cs.exception.Contenuto.FotoNotValidExcetion;
import it.unicam.cs.exception.Contenuto.LinkNotValidException;
import it.unicam.cs.exception.UtenteNotValidException;
import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.input.ContenutoContestDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.IContestRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.Interfaces.IContestService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.TipoContenuto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ControlloContenutoContestService {
    @Autowired
    private IUtenteService utenteService;
    @Autowired
    private IContestService contestService;
    @Autowired
    private IContestRepository contestRepository;

    public void verificaContenutoContest(ContenutoContestDto contenutoContestDto){
        verificaTipoContenuto(contenutoContestDto);
        verificaIdUtenteEContest(contenutoContestDto.getIdContestAssociato(), contenutoContestDto.getIdUtente());
    }
    private void verificaIdUtenteEContest(Integer idContestAssociato, Integer idUtente) {
        Contest contest = contestRepository.caricaPartecipantiContest(idContestAssociato);
        Utente utente = utenteService.ottieniUtente(idUtente);
        List<String> ruoli = utente.getRuoli().stream()
                .map(Ruolo::getNome)
                .collect(Collectors.toList());
        if(contest.isAttivo()){
            if(contest.getTipoInvito().name().equalsIgnoreCase("invito")) {
                if (!ruoli.contains(RuoliUtente.PARTECIPANTE_CONTEST.name()) && !contest.getPartecipantiContest().contains(utente)) {
                    throw new UtenteNotValidException("utente non autorizzato a inserire il contenuto nel contest");
                }
            }
        }
        else {
            throw new NullPointerException("il contest inserito non esiste o è chiuso");
        }
    }

    private void verificaTipoContenuto(ContenutoContestDto contenutoContestDto) {
        if (contenutoContestDto.getTipoContenuto() == null) {
            throw new NullPointerException("il tipo del contenuto per il contest non può essere nullo");
        }
        if (contenutoContestDto.getTipoContenuto().equalsIgnoreCase(TipoContenuto.FOTO.name())) {
            controllaFoto(contenutoContestDto.getNome());
        } else if (contenutoContestDto.getTipoContenuto().equalsIgnoreCase(TipoContenuto.LINK.name())) {
            controllaLink(contenutoContestDto.getNome());
        } else if (contenutoContestDto.getTipoContenuto().equalsIgnoreCase(TipoContenuto.DIDASCALIA.name())) {
            controllaNome(contenutoContestDto.getNome());
        } else throw new IllegalArgumentException("il tipo del contenuto per il contest non esiste");
    }

    private void controllaNome(String nome) {
        if(nome.isBlank()){
            throw new IllegalArgumentException("il nome non può essere nullo, vuoto e non può " +
                    "contenere solo spazi bianchi ");
        }
        if (nome.trim().length()<3 && nome.trim().length()>20){
            throw new IllegalArgumentException("lunghezza nome incorretta");
        }
    }

    private void controllaLink(String nome) {
        if(nome == null){
            throw new NullPointerException("la stringa per il link non può esssre nulla");
        }
        Pattern pattern = Pattern.compile("^(http(s)?://)?([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}(/[a-zA-Z0-9-_.~%]+)*(/\\?[a-zA-Z0-9-_.~&=]+)?$");
        boolean valid = pattern.matcher(nome).matches();
        if(!valid){
            throw new LinkNotValidException();
        }
    }

    private void controllaFoto(String nome) {
        if (!((nome == null) || nome.endsWith(".jpg")
                || nome.endsWith(".png") || nome.endsWith(".jpeg"))) {
            throw new FotoNotValidExcetion();
        }
    }

}
