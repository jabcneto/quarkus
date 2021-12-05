package com.jabcneto.service;

import com.jabcneto.model.Carta;
import com.jabcneto.model.dto.CartaDTO;
import com.jabcneto.repository.CartaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CartaService {

    @Inject
    CartaRepository repository;

    @Transactional
    public void cadastra(CartaDTO dto) {
        Carta carta = new Carta();
        carta.setAtaque(dto.getAtaque());
        carta.setDefesa(dto.getDefesa());
        carta.setClasse(dto.getClasse());
        carta.setCusto(dto.getCusto());
        carta.setDescricao(dto.getDescricao());
        carta.setNome(dto.getNome());
        carta.setTipo(dto.getTipo());
        repository.persist(carta);
    }

    public List<Carta> buscaTodas() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    public Carta buscaUmaPorId(Long id) {
        Carta byId = repository.findById(id);
        if (byId != null)
            return byId;
        throw new RuntimeException("Carta não encontrada!");
    }

    public void deletarPeloId(Long id) {
        repository.deleteById(id);
    }
}
