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

    public Pessoa atualizar(Long id, Pessoa pessoa) {
        Pessoa pessoSalva = pessoaRepository.findById(id).orElse(null);

        if (pessoSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(pessoa, pessoSalva, "id");
        return pessoaRepository.save(pessoSalva);
    }
}
