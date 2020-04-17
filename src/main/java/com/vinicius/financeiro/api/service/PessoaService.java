package com.vinicius.financeiro.api.service;

import com.vinicius.financeiro.api.model.Pessoa;
import com.vinicius.financeiro.api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa atualizar(Long codigo, Pessoa pessoa) {
        Pessoa pessoSalva = buscarPessoaPeloCodigo(codigo);

        BeanUtils.copyProperties(pessoa, pessoSalva, "codigo");
        return pessoaRepository.save(pessoSalva);
    }


    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
        Pessoa pessoSalva = buscarPessoaPeloCodigo(codigo);
        pessoSalva.setAtivo(ativo);
        pessoaRepository.save(pessoSalva);
    }

    public Pessoa buscarPessoaPeloCodigo(Long codigo) {
        Pessoa pessoSalva = pessoaRepository.findById(codigo).orElse(null);
        if (pessoSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return pessoSalva;
    }
}
