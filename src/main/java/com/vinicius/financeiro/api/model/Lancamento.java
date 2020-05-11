package com.vinicius.financeiro.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @Column(name = "CODIGO")
    private Long codigo;

    @NotNull
    @Column(name = "DESCRICAO")
    private String descricao;

    @NotNull
    @Column(name = "DATA_VENCIMENTO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;

    @Column(name = "DATA_PAGAMENTO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPagamento;

    @NotNull
    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO")
    private TipoLancamento tipo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CODIGO_CATEGORIA")
    private Categoria categoria;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CODIGO_PESSOA")
    private Pessoa pessoa;
}

