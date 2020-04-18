package com.vinicius.financeiro.api.controller;

import com.vinicius.financeiro.api.event.RecursoCriadoEvent;
import com.vinicius.financeiro.api.exceptionhandler.FinanceiroExceptionHandler;
import com.vinicius.financeiro.api.model.Lancamento;
import com.vinicius.financeiro.api.repository.LancamentoRepository;
import com.vinicius.financeiro.api.repository.filter.LancamentoFilter;
import com.vinicius.financeiro.api.service.LancamentoService;
import com.vinicius.financeiro.api.service.exception.PessoaInexistenteOuInativaException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private final LancamentoRepository lancamentoRepository;

    @Autowired
    private final LancamentoService lancamentoService;

    @Autowired
    private final ApplicationEventPublisher publisher;

    @Autowired
    private final MessageSource messageSource;

    @GetMapping
    public Page<Lancamento> pesquisar(LancamentoFilter lancamentoFilter, Pageable pageable) {
        return lancamentoRepository.filtrar(lancamentoFilter, pageable);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Lancamento> buscaPeloId(@PathVariable Long codigo) {
        Lancamento lancamento = lancamentoRepository.findById(codigo).orElse(null);
        return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
        Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamento);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long codigo) {
        lancamentoRepository.deleteById(codigo);
    }

    @ExceptionHandler({PessoaInexistenteOuInativaException.class})
    public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex) {
        String mensagemUsuario = messageSource.getMessage("pessoa.inexistente-ou-inativa", null, LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = ex.toString();
        List<FinanceiroExceptionHandler.Erro> erros = Arrays.asList(new FinanceiroExceptionHandler.Erro(mensagemUsuario, mensagemDesenvolvedor));
        return ResponseEntity.badRequest().body(erros);
    }
}
