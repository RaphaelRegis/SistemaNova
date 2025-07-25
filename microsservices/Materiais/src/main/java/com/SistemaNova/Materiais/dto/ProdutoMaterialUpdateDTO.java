package com.SistemaNova.Materiais.dto;

public record ProdutoMaterialUpdateDTO(
        Integer qtd,
        String offsetAltura,
        String offsetLargura,
        String criterio
) {
}
