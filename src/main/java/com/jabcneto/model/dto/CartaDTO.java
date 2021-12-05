package com.jabcneto.model.dto;

import com.jabcneto.model.enums.Classe;
import com.jabcneto.model.enums.Tipo;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CartaDTO {
    private String nome;
    private String descricao;
    @Min(0)
    @Max(10)
    private Integer custo;
    @Min(0)
    @Max(10)
    private Integer ataque;
    @Min(0)
    @Max(10)
    private Integer defesa;
    private Tipo tipo;
    private Classe classe;
}
