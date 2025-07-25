package com.SistemaNova.Materiais.dto;

public record ProdutoMaterialSaveDTO(
        Integer idProduto,
        Integer idMaterial,
        Integer qtd,
        String offsetAltura,
        String offsetLargura,
        String criterio
) {
}
