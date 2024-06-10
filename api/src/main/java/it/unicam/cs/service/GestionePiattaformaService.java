package it.unicam.cs.service;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.ComuneDTO;
import it.unicam.cs.model.DTO.input.ComuneDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.proxy.ProxyService;
import it.unicam.cs.repository.IComuneRepository;
import it.unicam.cs.service.Interfaces.IGestionePiattaformaService;
import it.unicam.cs.service.Interfaces.IProxyService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.info.Posizione;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestionePiattaformaService implements IGestionePiattaformaService {
    private final IComuneRepository comuneRepository;
    private final IUtenteService utenteService;
    private final OSMService osmService;
    public GestionePiattaformaService(IComuneRepository comuneRepository, IUtenteService utenteService, OSMService osmService){
        this.comuneRepository = comuneRepository;
        this.utenteService = utenteService;
        this.osmService = osmService;
    }
    @Override
    public void aggiungiComune(ComuneDto comuneDto) {
        Comune comuneTrovato = comuneRepository.findByNome(comuneDto.getNome());
        if(comuneTrovato != null){
            throw new IllegalArgumentException("Il comune è già stato registrato");
        }
        List<Posizione> perimetro = osmService.ottieniPerimetro(comuneDto.getNome());
        Posizione posizione = osmService.ottieniPosizioneComune(comuneDto.getNome());
        Comune comune1 = new Comune(comuneDto.getNome(),posizione,perimetro);
        comuneRepository.save(comune1);

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
    public Integer aggiungiGestoreComune(Integer idGestoreComune, String comune) {
        Comune comuneTrovato = comuneRepository.findByNome(comune);
        Utente gestoreComune = utenteService.ottieniUtenteById(idGestoreComune);
        if(comuneTrovato != null && gestoreComune.getComuneAssociato().getNome().equalsIgnoreCase(comune)){
            if(!gestoreComune.getRuoli().stream().map(Ruolo::getNome).collect(Collectors.toList()).contains(RuoliUtente.GESTORE_PIATTAFORMA.name())){
                utenteService.assegnaRuoloAutente(gestoreComune.getUsername(), RuoliUtente.GESTORE_COMUNE.name());
            }
            comuneTrovato.setGestoreComune(gestoreComune);
            comuneRepository.save(comuneTrovato);
        }
        else {
            throw new IllegalArgumentException("comune non esistente o utente non appartentente al comune");
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
    public Comune ottieniComune(int idComune) {
        return comuneRepository.findById(idComune).orElse(null);
    }

    @Override
    public Comune ottieniComune(String nomeComune) {
        return comuneRepository.findByNome(nomeComune);
    }
    @Override
    public Collection<ComuneDTO> ottieniComuni(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Comune> comuni = comuneRepository.findAll(pageable);
        return comuni.getContent().stream().map((comune -> comuneRepository.convertiComuneinDto(comune)))
                .collect(Collectors.toList());
    }
}
