package com.vinicius.financeiro.api.repository.lancamento;

import com.vinicius.financeiro.api.model.Lancamento;
import com.vinicius.financeiro.api.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
}
