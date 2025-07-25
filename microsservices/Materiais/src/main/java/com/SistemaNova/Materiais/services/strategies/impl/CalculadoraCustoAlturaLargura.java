package com.SistemaNova.Materiais.services.strategies.impl;

import com.SistemaNova.Materiais.services.dto.CalculoCustoDTO;
import com.SistemaNova.Materiais.services.strategies.CalculadoraCustoStrategy;

import java.math.BigDecimal;

public class CalculadoraCustoAlturaLargura implements CalculadoraCustoStrategy {

    @Override
    public String calcularValor(CalculoCustoDTO calculoCustoDTO) {

        BigDecimal valor = new BigDecimal(calculoCustoDTO.valorMaterial());
        valor = valor.multiply(new BigDecimal(calculoCustoDTO.qtd()));
        valor = valor.multiply(new BigDecimal(calculoCustoDTO.altura()));
        valor = valor.multiply(new BigDecimal(calculoCustoDTO.largura()));

        return valor.toString();
    }
}
