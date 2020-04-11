package com.vinicius.financeiro.api.controller;

import com.vinicius.financeiro.api.model.Categoria;
import com.vinicius.financeiro.api.repository.CategoriaRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepositoy categoriaRepositoy;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepositoy.findAll();
    }

}
