package com.vinicius.financeiro.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "permissao")
public class Permissao {

    @EqualsAndHashCode.Include
    @Id
    private Long codigo;

    private String descricao;
}
