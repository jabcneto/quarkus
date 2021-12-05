package com.jabcneto.model.dto;

import com.jabcneto.model.enums.Classe;
import lombok.Data;


@Data
public class BaralhoDTO {

    private Long idUsuario;
    private String nome;
    private String descricao;
    private Classe classe;

}
