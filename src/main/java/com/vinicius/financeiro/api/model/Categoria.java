package com.vinicius.financeiro.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_SEQ")
    @SequenceGenerator(name = "CATEGORIA_SEQ", sequenceName = "CATEGORIA_SEQ", allocationSize = 1)
    @Column(name = "ID_CATEGORIA")
    private long id_categoria;

    @NotNull
    @Column(name = "NOME")
    private String nome;

}
