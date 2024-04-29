package it.unicam.cs.service;

import it.unicam.cs.model.DTO.UtenteDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.IRuoloRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.Interfaces.IUtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j
public class UtenteService implements IUtenteService,UserDetailsService {
    private final UtenteRepository utenteRepository;
    private final IRuoloRepository ruoloRepository;

    public UtenteService(UtenteRepository utenteRepository,
                         IRuoloRepository ruoloRepository)
    {
        this.utenteRepository = utenteRepository;
        this.ruoloRepository = ruoloRepository;
    }

    @Override
    public Utente salvaUtente(Utente utente) {
        log.info("Aggiunto utente {} nel db",utente.getUsername());
        return utenteRepository.save(utente);
    }

    @Override
    public Ruolo salvaRuolo(Ruolo ruolo) {
        log.info("Aggiunto ruolo {} nel db",ruolo.getNome());
        return ruoloRepository.save(ruolo);
    }

    @Override
    public void assegnaRuoloAutente(String username, String nomeRuolo) {
        Utente utente = utenteRepository.findByUsername(username);
        Ruolo ruolo = ruoloRepository.findByNome(nomeRuolo);
        log.info("Ruolo {} assegnato all'utente {} ",ruolo.getNome(),utente.getUsername());
        utente.getRuoli().add(ruolo);
    }

    @Override
    public Utente ottieniUtente(String username) {
        log.info("Ottieni utente {} ",username);
        return utenteRepository.findByUsername(username);
    }

    @Override
    public List<UtenteDto> ottieniUtenti(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Utente> utenti = utenteRepository.findAll(pageable);
        log.info("Ottieni lista utenti ");
        return utenti.getContent().stream().map((utente -> utenteRepository.convertiUtenteinDto(utente)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ruolo> ottieniRuoliUtente(String utente) {
        log.info("Ottieni ruoli utente {}", utente);
        return utenteRepository.findByUsername(utente).getRuoli();
    }

    @Override
    public UserDetailsService userDetailsService() {
        return username -> utenteRepository.findByUsername(username);
    }

    @Override
    public void rimuoviUtente(Utente utente) {
        if(utenteRepository.findByUsername(utente.getUsername()) != null){
            utenteRepository.delete(utente);
        }
        log.info("Rimosso utente {} dal db", utente.getUsername());
    }

    @Override
    public Utente ottieniUtente(int id) {
        return utenteRepository.findById(id).orElse(null);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utente = utenteRepository.findByUsername(username);
        if(utente == null) {
            log.error("Utente non trovato nel db");
            throw new UsernameNotFoundException("Utente non trovato nel db");
        }
        else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            utente.getRuoli().forEach((ruolo) -> authorities.add( new SimpleGrantedAuthority(ruolo.getNome())));
            log.info("Utente {} trovato nel db!",utente.getUsername());
            return new org.springframework.security.core.userdetails.User(utente.getUsername(),
                                                                      utente.getPassword(),
                                                                       authorities);
        }
    }

}
