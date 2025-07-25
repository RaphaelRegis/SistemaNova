package com.SistemaNova.produtos_sob_medida.controllers;

import com.SistemaNova.produtos_sob_medida.dto.ProdutoSobMedidaSaveDTO;
import com.SistemaNova.produtos_sob_medida.dto.ProdutoSobMedidaUpdateDTO;
import com.SistemaNova.produtos_sob_medida.entities.ProdutoSobMedida;
import com.SistemaNova.produtos_sob_medida.services.ProdutoSobMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos-sob-medida")
public class ProdutoSobMedidaController {

    @Autowired
    private ProdutoSobMedidaService produtoSobMedidaService;

    @PostMapping
    public ResponseEntity<ProdutoSobMedida> save(ProdutoSobMedidaSaveDTO produtoSobMedidaSaveDTO) {
        return ResponseEntity.ok(produtoSobMedidaService.save(produtoSobMedidaSaveDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoSobMedida>> findAll() {
        return ResponseEntity.ok(produtoSobMedidaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoSobMedida> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(produtoSobMedidaService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoSobMedida> update(@PathVariable("id") Integer id, @RequestBody ProdutoSobMedidaUpdateDTO produtoSobMedidaUpdateDTO) {
        return ResponseEntity.ok(produtoSobMedidaService.update(id, produtoSobMedidaUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoSobMedida> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(produtoSobMedidaService.delete(id));
    }
}
