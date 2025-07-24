package com.SistemaNova.catalogo_produtos.controllers;

import com.SistemaNova.catalogo_produtos.dto.ProdutoDTO;
import com.SistemaNova.catalogo_produtos.entities.Produto;
import com.SistemaNova.catalogo_produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/catalogo")
public class CatalogoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoService.save(produtoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Integer id, @RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoService.update(id, produtoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(produtoService.delete(id));
    }
}
