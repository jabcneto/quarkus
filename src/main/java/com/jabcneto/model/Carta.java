package com.jabcneto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jabcneto.model.enums.Classe;
import com.jabcneto.model.enums.Tipo;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    private String descricao;
    @Min(0)
    @Max(10)
    @NotNull
    private Integer custo;
    @Min(0)
    @Max(10)
    @NotNull
    private Integer ataque;
    @Min(0)
    @Max(10)
    @NotNull
    private Integer defesa;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Classe classe;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "baralho_carta",
            joinColumns = @JoinColumn(name = "cartas_id"),
            inverseJoinColumns = @JoinColumn(name = "baralho_id"))
    private List<Baralho> baralhos;


}
