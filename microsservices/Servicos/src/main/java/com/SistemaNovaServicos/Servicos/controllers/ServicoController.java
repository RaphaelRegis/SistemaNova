package com.SistemaNovaServicos.Servicos.controllers;

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

import com.SistemaNovaServicos.Servicos.dto.ServicoSaveDTO;
import com.SistemaNovaServicos.Servicos.dto.ServicoUpdateDTO;
import com.SistemaNovaServicos.Servicos.entities.Servico;
import com.SistemaNovaServicos.Servicos.services.ServicoService;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {
    
    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> save(@RequestBody ServicoSaveDTO servicoSaveDTO) {
        return ResponseEntity.ok(servicoService.save(servicoSaveDTO));
    }

    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        return ResponseEntity.ok(servicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicoService.findById(id));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Servico> update(@PathVariable("id") Integer id, @RequestBody ServicoUpdateDTO servicoUpdateDTO) {
        return ResponseEntity.ok(servicoService.update(id, servicoUpdateDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Servico> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicoService.delete(id));
    }

    // CORRIGIR QUANDO A LOGICA EXISTIR
    public ResponseEntity<Servico> deleteAllByTrabalho(@PathVariable("id") Integer id_trabalho) {
        return ResponseEntity.ok(servicoService.deleteAllByTrabalho(id_trabalho));
    }


}
