package br.com.fiap.moneyminder.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.moneyminder.model.Categoria;
import br.com.fiap.moneyminder.repository.CategoriaRepository;


@RestController 
@RequestMapping("/categoria")
@Slf4j
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;
    

    @GetMapping
    public List<Categoria> index(){
        return categoriaRepository.findAll();
    }


    @PostMapping
    @ResponseStatus(CREATED)
    public Categoria create(@RequestBody Categoria categoria){ 
        log.info("cadastrando categoria: {}", categoria );

        return categoriaRepository.save(categoria);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id){
        log.info("Buscar por id: {}", id);
        
        return  categoriaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        log.info("Deletando categoria: {}", id);
        
        verificaSeExisteCategoria(id);
        categoriaRepository.deleteById(id);

    }

    @PutMapping("{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        log.info("atualizando categoria id {} para {}", id, categoria);
        
        verificaSeExisteCategoria(id);

        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    private void verificaSeExisteCategoria(Long id){
        categoriaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));

    }

}
