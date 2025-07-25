package com.SistemaNova.produtos_sob_medida.dto;

public record ProdutoSobMedidaSaveDTO(
        Integer idProduto,
        Integer idTrabalho,
        String altura,
        String largura,
        String margemLucro
) {
}
