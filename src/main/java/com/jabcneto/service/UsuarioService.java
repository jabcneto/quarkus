package com.jabcneto.service;

import com.jabcneto.model.Usuario;
import com.jabcneto.model.dto.UsuarioDTO;
import com.jabcneto.repository.UsuarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository repository;

    public Usuario buscaPorId(Long id) {
        Usuario byId = repository.findById(id);
        if (byId != null)
            return byId;
        throw new RuntimeException("Usuário não cadastrado!");
    }

    @Transactional
    public void cadastra(UsuarioDTO dto) {
        Optional<Usuario> opt = repository.findByEmail(dto.getEmail());

        if (opt.isPresent()) {
            throw new RuntimeException("Já existe usuário cadastrado com esse email!");
        }
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        repository.persist(usuario);

    }

    public List<Usuario> buscaTodas() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    public Usuario buscaUmaPorId(Long id) {
        Usuario byId = repository.findById(id);
        if (byId != null)
            return byId;
        throw new RuntimeException("Carta não encontrada!");
    }

    public void deletarPeloId(Long id) {
        repository.deleteById(id);
    }
}
