package com.jabcneto.repository;

import com.jabcneto.model.Carta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
    public class CartaRepository implements PanacheRepository<Carta> {
}