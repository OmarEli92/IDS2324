package it.unicam.cs.service;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.ComuneDTO;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.IComuneRepository;
import it.unicam.cs.service.Interfaces.IGestionePiattaformaService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestionePiattaformaService implements IGestionePiattaformaService {
    private final IComuneRepository comuneRepository;
    private final IUtenteService utenteService;
    public GestionePiattaformaService(IComuneRepository comuneRepository, IUtenteService utenteService){
        this.comuneRepository = comuneRepository;
        this.utenteService = utenteService;
    }
    @Override
    public void aggiungiComune(Comune comune) {
        Comune comuneTrovato = comuneRepository.findByNome(comune.getNome());
        if(comuneTrovato == null){
            comuneRepository.save(comune);
        }
        throw new IllegalArgumentException("Il comune è già stato registrato");
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
