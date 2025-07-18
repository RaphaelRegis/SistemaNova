package com.SistemaNova.Materiais.controllers;

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

import com.SistemaNova.Materiais.dto.MaterialDTO;
import com.SistemaNova.Materiais.entities.Material;
import com.SistemaNova.Materiais.services.MaterialService;

@RestController
@RequestMapping("/api/materiais")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping
    public ResponseEntity<Material> save(@RequestBody MaterialDTO materialDTO) {
        return ResponseEntity.ok(materialService.save(materialDTO));
    }

    @GetMapping
    public ResponseEntity<List<Material>> findAll() {
        return ResponseEntity.ok(materialService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(materialService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Material> findById(@PathVariable("id") Integer id,
            @RequestBody MaterialDTO materialDTO) {
        return ResponseEntity.ok(materialService.update(id, materialDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Material> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(materialService.delete(id));
    }

}
