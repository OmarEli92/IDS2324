package it.unicam.cs.service;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.input.UtenteDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IRuoloRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    private final IConsultazioneContenutiService consultazioneContenutiService;

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
        utenteRepository.save(utente);
    }

    @Override
    public Utente ottieniUtente(String username) {
        log.info("Ottieni utente {} ",username);
        return utenteRepository.findByUsername(username);
    }

    @Override
    public Utente ottieniUtenteById(Integer id) {
        log.info("Ottieni utente dall'id",id);
        Utente utente = utenteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Utente non trovato"));
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
    public Utente ottieniUtente(Integer id) {
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
    @Override
    @Transactional
    public void aggiungiPOI(Integer idUtente,POI poi){
        Utente utente = utenteRepository.findById(idUtente).orElseThrow(() -> new EntityNotFoundException("utente non trovato"));;
        utente.aggiungiPOI(poi);
        utenteRepository.save(utente);
    }
    @Override
    @Transactional
    public void aggiungiItinerario(Integer idUtente, Itinerario itinerario){
        Utente utente = utenteRepository.findById(idUtente).orElseThrow(() -> new EntityNotFoundException("utente non trovato"));;
        utente.aggiungiItinerario(itinerario);
        utenteRepository.save(utente);
    }
    @Override
    @Transactional
    public void aggiungiContenutoMultimediale(Integer idUtente, ContenutoMultimediale contenutoMultimediale){
        Utente utente = utenteRepository.findById(idUtente).orElseThrow(()->new EntityNotFoundException("utente non trovato"));
        utente.aggiungiContenutoMultimediale(contenutoMultimediale);
        utenteRepository.save(utente);
    }
    @Override
    @Transactional
    public void aggiungiEvento(Integer idUtente, Evento evento){
        Utente utente = utenteRepository.findById(idUtente).orElseThrow(() -> new EntityNotFoundException("utente non trovato"));;
        utente.aggiungiEvento(evento);
        utenteRepository.save(utente);
    }
    @Override
    @Transactional
    public void aggiungiContest(Integer idUtente, Contest contest){
        Utente utente = utenteRepository.findById(idUtente).orElseThrow(() -> new EntityNotFoundException("utente non trovato"));;
        utente.aggiungiContestCreato(contest);
        utenteRepository.save(utente);
    }
    @Override
    @Transactional
    public void aggiungiContenutoContest(Integer idUtente, ContenutoContest contenutoContest){
        Utente utente = utenteRepository.findById(idUtente).orElseThrow(() -> new EntityNotFoundException("utente non trovato"));;
        utente.aggiungiContenutoContestCreato(contenutoContest);
        utenteRepository.save(utente);
    }
    @Override
    @Transactional
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
    @Override
    @Transactional
    public void aggiornaListaItinerario(Integer idItinerario, boolean validato){
        Utente utente = utenteRepository.findByIitinerarioId(idItinerario);
        if(validato){
            utente.getItinerariCreati()
                    .stream()
                    .filter(itinerario -> itinerario.getId().equals(idItinerario))
                    .forEach(itinerario -> itinerario.setStato(StatoElemento.PUBBLICATO));
            utenteRepository.save(utente);
        }
        else{
            Itinerario itinerario = consultazioneContenutiService.ottieniItinerarioDaId(idItinerario);
            utente.getItinerariCreati().remove(itinerario);
            utenteRepository.save(utente);
        }
    }
    @Override
    @Transactional
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
    @Override
    @Transactional
    public void aggiornaListaContenutiMultimediali(Integer idContenutoMultimediale, boolean validato){
        Utente utente = utenteRepository.findByContenutoMultimedialeId(idContenutoMultimediale);
        if(validato){
            utente.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.PUBBLICATO));
            utenteRepository.save(utente);
        }
        else {
            ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
            utente.getContenutiMultimediali().remove(contenutoMultimediale);
            utenteRepository.save(utente);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaContenutiContest(Integer idContenutoContest, boolean validato){
        Utente utente = utenteRepository.findByContenutoContest(idContenutoContest);
        if(validato){
            utente.getContenutoContestCreati()
                    .stream()
                    .filter(contenutoContest -> contenutoContest.getId().equals(idContenutoContest))
                    .forEach(contenutoContest -> contenutoContest.setPending(false));
            utenteRepository.save(utente);
        }
        else{
            ContenutoContest contenutoContest = consultazioneContenutiService.ottieniContenutoContestDaid(idContenutoContest);
            utente.getContenutoContestCreati().remove(contenutoContest);
            utenteRepository.save(utente);
        }
    }

    @Override
    @Transactional
    public void aggiornaListaContenutiMultimedialiSegnalati(Integer id) {
        Utente utente = utenteRepository.findByContenutoMultimedialeId(id);
        utente.getContenutiMultimediali()
                .stream()
                .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(id))
                .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.SEGNALATO));
    }

    @Override
    @Transactional
    public void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato) {
        Utente utente = utenteRepository.findByContenutoMultimedialeId(idContenutoMultimediale);
        ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
        if(eliminato){
            utente.getContenutiMultimediali().remove(contenutoMultimediale);
            utenteRepository.save(utente);
        }
        else {
            utente.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale1 -> contenutoMultimediale1.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale1 -> contenutoMultimediale1.setStato(StatoElemento.PUBBLICATO));
            utenteRepository.save(utente);
        }
    }

    @Override
    @Transactional
    public void aggiornaListaContestCreatiAperti(Integer idContest) {
        Utente utente = utenteRepository.findByContestCreatiId(idContest);
        utente.getContestCreati()
                .stream()
                .filter(contest -> contest.getId().equals(idContest))
                .forEach(contest -> contest.setAttivo(true));
        utenteRepository.save(utente);
    }

    @Override
    @Transactional
    public void aggiornaListaContestInPartecipazioneAperti(Integer idContest) {
        List<Utente> utenti = utenteRepository.findByContestinPartecipazioneId(idContest);
        utenti.forEach(utente -> {utente.getContestInPartecipazione()
                .stream()
                .filter(contest -> contest.getId().equals(idContest))
                .forEach(contest -> contest.setAttivo(true));
        utenteRepository.save(utente);});
    }
    @Override
    @Transactional
    public void aggiornaListaContestDaChiudere(Integer idContest) {
        Utente utente = utenteRepository.findByContestCreatiId(idContest);
        utente.getContestCreati()
                .stream()
                .filter(contest -> contest.getId().equals(idContest))
                .forEach(contest -> contest.setAttivo(false));
    }

    @Override
    @Transactional
    public void aggiornaListaEventiCreatiDaAprire(Integer idEvento) {
        Utente utente = utenteRepository.findByEventoId(idEvento);
        utente.getEventiCreati()
                .stream()
                .filter(evento -> evento.getId().equals(idEvento))
                .forEach(evento -> evento.setAperto(true));
        utenteRepository.save(utente);
    }

    @Override
    @Transactional
    public void aggiornaListaEventiCreatiDaChiudere(Integer idEvento) {
        Utente utente = utenteRepository.findByEventoId(idEvento);
        Evento evento = consultazioneContenutiService.ottieniEventoDaId(idEvento);
        utente.getEventiCreati().remove(evento);
        utenteRepository.save(utente);
    }
}
