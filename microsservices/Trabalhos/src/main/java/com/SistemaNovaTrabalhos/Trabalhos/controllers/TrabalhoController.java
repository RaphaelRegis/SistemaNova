package com.SistemaNovaTrabalhos.Trabalhos.controllers;

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

import com.SistemaNovaTrabalhos.Trabalhos.dto.TrabalhoSaveDTO;
import com.SistemaNovaTrabalhos.Trabalhos.dto.TrabalhoValorDTO;
import com.SistemaNovaTrabalhos.Trabalhos.entities.Trabalho;
import com.SistemaNovaTrabalhos.Trabalhos.services.TrabalhoService;

@RestController
@RequestMapping("/api/trabalhos")
public class TrabalhoController {
    
    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping
    public ResponseEntity<Trabalho> save(@RequestBody TrabalhoSaveDTO trabalhoSaveDTO) {
        return ResponseEntity.ok(trabalhoService.save(trabalhoSaveDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabalho> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(trabalhoService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Trabalho>> findAll() {
        return ResponseEntity.ok(trabalhoService.findAll());
    }

    @PatchMapping("/valor/{id}")
    public ResponseEntity<Trabalho> updateValor(@PathVariable("id") Integer id, @RequestBody TrabalhoValorDTO trabalhoValorDTO) {
        return ResponseEntity.ok(trabalhoService.updateValor(id, trabalhoValorDTO));
    }
    
    @PatchMapping("/estado/{id}")
    public ResponseEntity<Trabalho> updateEstado(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(trabalhoService.updateEstado(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Trabalho> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(trabalhoService.delete(id));
    }
}
