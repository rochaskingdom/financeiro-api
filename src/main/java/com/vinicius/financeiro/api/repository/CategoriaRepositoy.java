package com.vinicius.financeiro.api.repository;

import com.vinicius.financeiro.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositoy extends JpaRepository<Categoria, Long> {
}
