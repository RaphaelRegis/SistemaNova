package com.SistemaNovaEnderecos.Enderecos.controllers;

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

import com.SistemaNovaEnderecos.Enderecos.dto.EnderecoDTO;
import com.SistemaNovaEnderecos.Enderecos.dto.DividaUpdateDTO;
import com.SistemaNovaEnderecos.Enderecos.entities.Endereco;
import com.SistemaNovaEnderecos.Enderecos.services.EnderecoService;

@RestController
@RequestMapping("api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody EnderecoDTO enderecoSaveDTO){
        return ResponseEntity.ok(enderecoService.save(enderecoSaveDTO));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(enderecoService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Endereco> update(@PathVariable("id") Integer id, @RequestBody EnderecoDTO enderecoDTO){
        return ResponseEntity.ok(enderecoService.update(id, enderecoDTO));
    }
    
    @PatchMapping("/divida/{id}")
    public ResponseEntity<Endereco> updateDivida(@PathVariable("id") Integer id, @RequestBody DividaUpdateDTO dividaUpdateDTO){
        return ResponseEntity.ok(enderecoService.updateDivida(id, dividaUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Endereco> delete(@PathVariable("id") Integer id){
        return ResponseEntity.ok(enderecoService.delete(id));
    }
    
}
