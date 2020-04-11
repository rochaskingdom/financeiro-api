package com.vinicius.financeiro.api.repository;

import com.vinicius.financeiro.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositoy extends JpaRepository<Categoria, Long> {
}
