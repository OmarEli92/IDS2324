package it.unicam.cs.service;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.ComuneDTO;
import it.unicam.cs.model.Utente;
import it.unicam.cs.proxy.ProxyService;
import it.unicam.cs.repository.IComuneRepository;
import it.unicam.cs.service.Interfaces.IGestionePiattaformaService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.info.Posizione;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service @Slf4j
public class GestionePiattaformaService implements IGestionePiattaformaService {
    private final IComuneRepository comuneRepository;
    private final IUtenteService utenteService;
    private final ProxyService proxyService;

    public GestionePiattaformaService(IComuneRepository comuneRepository, IUtenteService utenteService, ProxyService proxyService){
        this.comuneRepository = comuneRepository;
        this.utenteService = utenteService;
        this.proxyService = proxyService;

    }
    @Override
    public void aggiungiComune(Comune comune) {
        Comune comuneTrovato = comuneRepository.findByNome(comune.getNome());
        if(comuneTrovato == null){
            log.info("il comune non c'è nella repo");
            List<Posizione> perimetro = proxyService.ottieniPerimetro(comune.getNome());
            comune.setPerimetro(perimetro);
            comuneRepository.save(comune);
            log.info("Ho salvato il comune{} nella repo",comune.getNome());
        }
        else {

            throw new IllegalArgumentException("Il comune" + comuneTrovato.getNome() + " è già stato registrato");
        }
    }

    @Override
    public void rimuoviComune(int idComune) {
        comuneRepository.deleteById(idComune);
    }

    @Override
    public void rimuoviComune(String nomeComune) {
        Comune comuneDaEliminare = comuneRepository.findByNome(nomeComune);
        if(comuneDaEliminare != null)
            comuneRepository.delete(comuneDaEliminare);
    }

    @Override
    public int aggiungiGestoreComune(Utente gestoreComune, String comune) {
        Comune comuneTrovato = comuneRepository.findByNome(comune);
        if(comuneTrovato != null){
            comuneTrovato.setGestoreComune(gestoreComune);
            comuneRepository.save(comuneTrovato);
        }
        return gestoreComune.getId();
    }

    @Override
    public void rimuoviGestoreComune(int idGestore, String nomeComune) {
        Comune comune = comuneRepository.findByNome(nomeComune);
        if(comune != null){
            comune.setGestoreComune(null);
            comuneRepository.save(comune);
        }
        throw new IllegalArgumentException("Il comune non risulta essere registrato");
    }

    @Override
    public Optional<Comune> ottieniComune(int idComune) {
        return comuneRepository.findById(idComune);
    }

    @Override
    public Optional<Comune> ottieniComune(String nomeComune) {
        return Optional.of(comuneRepository.findByNome(nomeComune));
    }
    @Override
    public Collection<ComuneDTO> ottieniComuni(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Comune> comuni = comuneRepository.findAll(pageable);
        return comuni.getContent().stream().map((comune -> comuneRepository.convertiComuneinDto(comune)))
                .collect(Collectors.toList());
    }
}
