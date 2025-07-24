package com.SistemaNova.catalogo_produtos.entities;

import com.SistemaNova.catalogo_produtos.entities.enums.TipoProduto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String margemLucro;
    private TipoProduto tipoProduto;
}
