package com.vinicius.financeiro.api.repository;

import com.vinicius.financeiro.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
