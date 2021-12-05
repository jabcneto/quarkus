package com.jabcneto.service;

import com.jabcneto.model.Baralho;
import com.jabcneto.model.Carta;
import com.jabcneto.model.Usuario;
import com.jabcneto.model.dto.BaralhoDTO;
import com.jabcneto.model.dto.CartaDTO;
import com.jabcneto.model.enums.Classe;
import com.jabcneto.repository.BaralhoRepository;
import com.jabcneto.repository.CartaRepository;
import com.jabcneto.repository.UsuarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BaralhoService {

    @Inject
    BaralhoRepository repository;

    @Inject
    CartaService cartaService;

    @Inject
    UsuarioService usuarioService;

    @Transactional
    public void cadastra(BaralhoDTO dto) {
        Baralho baralho = new Baralho();
        baralho.setDescricao(dto.getDescricao());
        baralho.setClasse(dto.getClasse());
        baralho.setNome(dto.getNome());
        Usuario usuario = usuarioService.buscaPorId(dto.getIdUsuario());
        baralho.setUsuario(usuario);
        repository.persist(baralho);
    }

    @Transactional
    public Baralho adicionaCarta(Long idBaralho, Long idCarta) {
        Carta carta = cartaService.buscaUmaPorId(idCarta);

        Baralho baralho = repository.findById(idBaralho);
        int quantidateCartas = baralho.getCartas().stream().filter(e -> e.getId() == idCarta).collect(Collectors.toList()).size();

        if (baralho.getCartas().size() <= 30) {
            if(baralho.getClasse() != Classe.Qualquer && !baralho.getClasse().equals(carta.getClasse())){
                throw new RuntimeException("O baralho so pode ter cartas da sua classe ou cartas da classe livre");
            }

            if (quantidateCartas < 2) {
                baralho.getCartas().add(carta);
                repository.persist(baralho);
                return baralho;
            }
            throw new RuntimeException("O baralho so pode ter duas cartas iguais!");
        }
        throw new RuntimeException("O baralho so pode ter trinta cartas!");
    }

    public List<Baralho> buscaTodas() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    public Baralho buscaUmaPorId(Long id) {
        Baralho byId = repository.findById(id);
        if (byId != null)
            return byId;
        throw new RuntimeException("Baralho não encontrado!");
    }

    public void deletarPeloId(Long id) {
        repository.deleteById(id);
    }

}
