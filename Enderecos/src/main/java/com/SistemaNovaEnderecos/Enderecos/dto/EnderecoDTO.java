package com.SistemaNovaEnderecos.Enderecos.dto;

public record EnderecoDTO(
        String cidade,
        String logradouro,
        Integer numero,
        Integer id_cliente) {

}
