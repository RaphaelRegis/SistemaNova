package com.SistemaNova.ProdutoBase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaNova.ProdutoBase.dto.ProdutoBaseDTO;
import com.SistemaNova.ProdutoBase.entities.ProdutoBase;
import com.SistemaNova.ProdutoBase.services.ProdutoBaseService;

@RestController
@RequestMapping("/api/produtobase")
public class ProdutoBaseController {

    @Autowired
    private ProdutoBaseService produtoBaseService;

    @PostMapping
    public ResponseEntity<ProdutoBase> save(@RequestBody ProdutoBaseDTO produtoBaseDTO) {
        return ResponseEntity.ok(produtoBaseService.save(produtoBaseDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoBase>> findAll() {
        return ResponseEntity.ok(produtoBaseService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoBase> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(produtoBaseService.findById(id));
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoBase> findById(@PathVariable("id") Integer id, @RequestBody ProdutoBaseDTO produtoBaseDTO) {
        return ResponseEntity.ok(produtoBaseService.update(id, produtoBaseDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoBase> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(produtoBaseService.delete(id));
    }
}
