package com.SistemaNovaClientes.Clientes.entities;

import com.SistemaNovaClientes.Clientes.entities.enums.Tipo_Pessoa;

import jakarta.persistence.Column;
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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_cliente;
    private String nome;
    @Column(nullable = true, unique = true)
    private String id_fiscal;
    private Tipo_Pessoa tipo_Pessoa;
    private String celular;
        
    public Cliente(String nome, String id_fiscal, String celular) {
        this.nome = nome;
        this.id_fiscal = id_fiscal;

        if (id_fiscal.length() > 11) {
            this.tipo_Pessoa = Tipo_Pessoa.CNPJ;
        } else {
            this.tipo_Pessoa = Tipo_Pessoa.CPF;
        }

        this.celular = celular;
    }

}
