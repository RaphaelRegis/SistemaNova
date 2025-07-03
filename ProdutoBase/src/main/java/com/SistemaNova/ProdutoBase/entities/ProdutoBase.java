package com.SistemaNova.ProdutoBase.entities;

import com.SistemaNova.ProdutoBase.entities.enums.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ProdutoBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Categoria categoria;

    public ProdutoBase(String nome, Categoria categoria){
        this.nome = nome;
        this.categoria = categoria;
    }
}
