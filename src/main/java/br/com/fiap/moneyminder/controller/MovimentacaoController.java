package br.com.fiap.moneyminder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyminder.repository.MovimentacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/movimentacao")
@Slf4j
public class MovimentacaoController {

  @Autowired
  MovimentacaoRepository movimentacaoRepository;

  @GetMapping("path")
  public List index() {
      return movimentacaoRepository.findAll();
  }
  
  
}
