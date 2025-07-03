package com.SistemaNova.Materiais.entities;

import com.SistemaNova.Materiais.entities.enums.UnidadeMedida;

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
public class Material {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String preco;
    private UnidadeMedida unidadeMedida;
    
    public Material(String nome, String preco, UnidadeMedida unidadeMedida) {
        this.nome = nome;
        this.preco = preco;
        this.unidadeMedida = unidadeMedida;
    }

    
}
