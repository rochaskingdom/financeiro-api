package com.vinicius.financeiro.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "LANCAMENTO")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LANCAMENTO_SEQ")
    @SequenceGenerator(name = "LANCAMENTO_SEQ", sequenceName = "LANCAMENTO_SEQ", allocationSize = 1)
    @Column(name = "ID_LANCAMENTO")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA_VENCIMENTO")
    private LocalDate dataVencimento;

    @Column(name = "DATA_PAGAMENTO")
    private LocalDate dataPagamento;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO")
    private TipoLancamento tipo;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;
}

