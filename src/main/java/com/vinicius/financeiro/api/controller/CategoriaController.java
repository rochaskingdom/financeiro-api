package com.vinicius.financeiro.api.controller;

import com.vinicius.financeiro.api.event.RecursoCriadoEvent;
import com.vinicius.financeiro.api.model.Categoria;
import com.vinicius.financeiro.api.repository.CategoriaRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepositoy categoriaRepositoy;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepositoy.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPeloId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaRepositoy.findById(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepositoy.save(categoria);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

}
