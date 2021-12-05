package com.jabcneto.repository;

import com.jabcneto.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
    public Optional<Usuario> findByEmail(String email) {
        return Optional.ofNullable(find("email", email).firstResult());
    }
}