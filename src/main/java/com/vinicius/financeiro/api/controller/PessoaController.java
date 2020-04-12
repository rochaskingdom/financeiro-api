package com.vinicius.financeiro.api.controller;

import com.vinicius.financeiro.api.event.RecursoCriadoEvent;
import com.vinicius.financeiro.api.model.Pessoa;
import com.vinicius.financeiro.api.repository.PessoaRepository;
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
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscaPeloId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

}
