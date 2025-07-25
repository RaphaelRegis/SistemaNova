package com.SistemaNova.Materiais.entities;

import com.SistemaNova.Materiais.entities.enums.Criterio;
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
public class ProdutoMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer idProduto;
    private Integer idMaterial;
    private Integer qtd;
    private String offsetAltura;
    private String offsetLargura;
    private Criterio criterio;
}
