package com.vinicius.financeiro.api.service;

import com.vinicius.financeiro.api.model.Lancamento;
import com.vinicius.financeiro.api.model.Pessoa;
import com.vinicius.financeiro.api.repository.LancamentoRepository;
import com.vinicius.financeiro.api.repository.PessoaRepository;
import com.vinicius.financeiro.api.service.exception.PessoaInexistenteOuInativaException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LancamentoService {

    @Autowired
    private final PessoaRepository pessoaRepository;

    @Autowired
    private final LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).orElse(null);
        if (pessoa == null || pessoa.isinativo()) {
            throw new PessoaInexistenteOuInativaException();
        }

        return lancamentoRepository.save(lancamento);
    }
}
