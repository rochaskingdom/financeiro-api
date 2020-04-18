package com.vinicius.financeiro.api.repository.lancamento;

import com.vinicius.financeiro.api.model.Lancamento;
import com.vinicius.financeiro.api.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
