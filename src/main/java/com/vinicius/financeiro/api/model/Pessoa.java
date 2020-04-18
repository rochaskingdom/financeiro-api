package com.vinicius.financeiro.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "PESSOA_SEQ", allocationSize = 1)
    @Column(name = "CODIGO")
    private Long codigo;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "NOME")
    private String nome;

    @Embedded
    @Column(name = "ENDERECO")
    private Endereco endereco;

    @NotNull
    @Column(name = "ATIVO")
    private boolean ativo;

    @JsonIgnore
    @Transient
    public boolean isinativo() {
        return !this.ativo;
    }
}
