package com.vinicius.financeiro.api.service;

import com.vinicius.financeiro.api.model.Lancamento;
import com.vinicius.financeiro.api.model.Pessoa;
import com.vinicius.financeiro.api.repository.LancamentoRepository;
import com.vinicius.financeiro.api.repository.PessoaRepository;
import com.vinicius.financeiro.api.service.exception.PessoaInexistenteOuInativaException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LancamentoService {

    @Autowired
    private final PessoaRepository pessoaRepository;

    @Autowired
    private final LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        validarPessoa(lancamento);
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        Lancamento lancamentoSalvo = lancamentoRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        if (!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
            validarPessoa(lancamento);
        }

        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");

        return lancamentoRepository.save(lancamentoSalvo);
    }

    private void validarPessoa(Lancamento lancamento) {
        Pessoa pessoa = null;

        if (lancamento.getPessoa().getCodigo() != null) {
            pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo())
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
        }

        if (pessoa == null || pessoa.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
    }
}
