package com.SistemaNova.produtos_sob_medida.dto;

public record ProdutoSobMedidaUpdateDTO(
        Integer idProduto,
        String altura,
        String largura,
        String estado,
        String margemLucro
) {
}
