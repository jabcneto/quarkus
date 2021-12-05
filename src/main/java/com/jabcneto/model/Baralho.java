package com.jabcneto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jabcneto.model.enums.Classe;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Baralho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String descricao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Classe classe;

    @ManyToMany
    private List<Carta> cartas;

    @ManyToOne
    @JsonIgnore
    private Usuario usuario;

}
