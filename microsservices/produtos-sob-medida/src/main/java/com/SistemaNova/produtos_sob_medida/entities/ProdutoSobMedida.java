package com.SistemaNova.produtos_sob_medida.entities;

import com.SistemaNova.produtos_sob_medida.entities.enums.Estado;
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
public class ProdutoSobMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer idProduto;
    private Integer idTrabalho;
    private String altura;
    private String largura;
    private String valorBase;
    private String valorTotal;
    private Estado estado;
}
