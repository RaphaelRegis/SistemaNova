package com.SistemaNovaEnderecos.Enderecos.entities;


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
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_endereco;
    private String cidade;
    private String logradouro;
    private Integer numero;
    private String divida;
    private Integer id_cliente;
    
    public Endereco(String cidade, String logradouro, Integer numero, Integer id_cliente) {
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.divida = "0.0";
        this.id_cliente = id_cliente;
    }
}
