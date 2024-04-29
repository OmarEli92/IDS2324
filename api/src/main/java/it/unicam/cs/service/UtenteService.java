package it.unicam.cs.service;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.UtenteDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IRuoloRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.enums.StatoElemento;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service @Slf4j
public class UtenteService implements IUtenteService,UserDetailsService {
    private final UtenteRepository utenteRepository;
    private final IRuoloRepository ruoloRepository;
    private final ConsultazioneContenutiService consultazioneContenutiService;

    public UtenteService(UtenteRepository utenteRepository,
                         IRuoloRepository ruoloRepository,
                         ConsultazioneContenutiService consultazioneContenutiService)
    {
        this.utenteRepository = utenteRepository;
        this.ruoloRepository = ruoloRepository;
        this.consultazioneContenutiService = consultazioneContenutiService;
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
    public Utente ottieniUtenteById(Integer id) {
        log.info("Ottieni utente dall'id",id);
        Utente utente = utenteRepository.findUtenteById(id);
        if(utente==null){
            throw new NullPointerException("utente non trovato");
        }
        return utente;
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
    public void aggiungiPOI(Integer idUtente,POI poi){
        Utente utente = utenteRepository.getReferenceById(idUtente);
        utente.aggiungiPOI(poi);
        utenteRepository.save(utente);
    }
    public void aggiungiItinerario(Integer idUtente, Itinerario itinerario){
        Utente utente = utenteRepository.getReferenceById(idUtente);
        utente.aggiungiItinerario(itinerario);
        utenteRepository.save(utente);
    }
    public void aggiungiContenutoMultimediale(Integer idUtente, ContenutoMultimediale contenutoMultimediale){
        Utente utente =utenteRepository.getReferenceById(idUtente);
        utente.aggiungiContenutoMultimediale(contenutoMultimediale);
        utenteRepository.save(utente);
    }
    public void aggiungiEvento(Integer idUtente, Evento evento){
        Utente utente = utenteRepository.getReferenceById(idUtente);
        utente.aggiungiEvento(evento);
        utenteRepository.save(utente);
    }
    public void aggiungiContest(Integer idUtente, Contest contest){
        Utente utente = utenteRepository.getReferenceById(idUtente);
        utente.aggiungiContestCreato(contest);
        utenteRepository.save(utente);
    }
    public void aggiungiContenutoContest(Integer idUtente, ContenutoContest contenutoContest){
        Utente utente = utenteRepository.getReferenceById(idUtente);
        utente.aggiungiContenutoContestCreato(contenutoContest);
        utenteRepository.save(utente);
    }
    public void aggiornaListaPOI(Integer idPOI, boolean validato){
        Utente utente = utenteRepository.findByPOIid(idPOI);
        if(validato){
            utente.getPoiCreati()
                    .stream()
                    .filter(poi -> poi.getId().equals(idPOI))
                    .forEach(poi -> poi.setStato(StatoElemento.PUBBLICATO));
            utenteRepository.save(utente);
        }
        else{
            POI poi = consultazioneContenutiService.ottieniPOIdaId(idPOI);
            utente.getPoiCreati().remove(poi);
            utenteRepository.save(utente);
        }
    }
    public void aggiornaListaItinerario(Integer idItinerario, boolean validato){
        Utente utente = utenteRepository.findByIitinerarioId(idItinerario);
        if(validato){
            utente.getItinerariCreati()
                    .stream()
                    .filter(itinerario -> itinerario.getId().equals(idItinerario))
                    .forEach(itinerario -> itinerario.setStato(utente));
            utenteRepository.save(utente);
        }
        else{
            Itinerario itinerario = consultazioneContenutiService.ottieniItinerarioDaId(idItinerario);
            utente.getItinerariCreati().remove(itinerario);
            utenteRepository.save(utente);
        }
    }
    public void aggiornaListaEvento(Integer idEvento, boolean validato){
        Utente utente = utenteRepository.findByEventoId(idEvento);
        if(validato){
            utente.getEventiCreati()
                    .stream()
                    .filter(evento -> evento.getId().equals(idEvento))
                    .forEach(evento -> evento.setStato(StatoElemento.PUBBLICATO));
            utenteRepository.save(utente);
        }
        else {
            Evento evento = consultazioneContenutiService.ottieniEventoDaId(idEvento);
            utente.getEventiCreati().remove(evento);
            utenteRepository.save(utente);
        }
    }
}
