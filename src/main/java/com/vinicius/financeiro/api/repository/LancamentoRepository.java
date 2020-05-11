package com.vinicius.financeiro.api.repository;

import com.vinicius.financeiro.api.model.Lancamento;
import com.vinicius.financeiro.api.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
}
