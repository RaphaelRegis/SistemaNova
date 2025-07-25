package com.SistemaNova.Materiais.controllers;

import com.SistemaNova.Materiais.dto.CalculoValorBaseDTO;
import com.SistemaNova.Materiais.dto.MaterialDTO;
import com.SistemaNova.Materiais.dto.ProdutoMaterialSaveDTO;
import com.SistemaNova.Materiais.dto.ProdutoMaterialUpdateDTO;
import com.SistemaNova.Materiais.entities.Material;
import com.SistemaNova.Materiais.entities.ProdutoMaterial;
import com.SistemaNova.Materiais.services.ProdutoMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos-materiais")
public class ProdutoMaterialController {
    
    @Autowired
    private ProdutoMaterialService produtoMaterialService;

    @PostMapping
    public ResponseEntity<ProdutoMaterial> save(@RequestBody ProdutoMaterialSaveDTO produtoMaterialSaveDTO) {
        return ResponseEntity.ok(produtoMaterialService.save(produtoMaterialSaveDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoMaterial>> findAll() {
        return ResponseEntity.ok(produtoMaterialService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoMaterial> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(produtoMaterialService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoMaterial> update(@PathVariable("id") Integer id, @RequestBody ProdutoMaterialUpdateDTO produtoMaterialUpdateDTO) {
        return ResponseEntity.ok(produtoMaterialService.update(id, produtoMaterialUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoMaterial> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(produtoMaterialService.delete(id));
    }

    @PostMapping("/calcularValorBase")
    public ResponseEntity<String> calcularValorBase(@RequestBody CalculoValorBaseDTO calculoValorBaseDTO) {
        return ResponseEntity.ok(produtoMaterialService.calcularValorBase(calculoValorBaseDTO));
    }
    
}
