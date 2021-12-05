package com.jabcneto.repository;

import com.jabcneto.model.Baralho;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
    public class BaralhoRepository implements PanacheRepository<Baralho> {
}