package com.jabcneto.model;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String nome;

    private Integer mmr = 200;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Baralho> baralho = new ArrayList<>();
}
