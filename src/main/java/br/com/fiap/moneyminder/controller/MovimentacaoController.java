package br.com.fiap.moneyminder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyminder.model.Movimentacao;
import br.com.fiap.moneyminder.repository.MovimentacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/movimentacao")
@Slf4j
public class MovimentacaoController {

  @Autowired
  MovimentacaoRepository movimentacaoRepository;

  @GetMapping
  public List<Movimentacao> index() {
      return movimentacaoRepository.findAll();
  }
  
  @PostMapping
  @ResponseStatus(CREATED)
  public Categoria create(@RequestBody @Valid Movimentacao movimentacao){ 
      log.info("cadastrando movimentação: {}", movimentacao );

      return movimentacaoRepository.save(movimentacao);
  }

  

}
