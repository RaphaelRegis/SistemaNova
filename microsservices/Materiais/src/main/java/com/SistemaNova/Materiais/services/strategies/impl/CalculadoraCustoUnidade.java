package com.SistemaNova.Materiais.services.strategies.impl;

import com.SistemaNova.Materiais.services.dto.CalculoCustoDTO;
import com.SistemaNova.Materiais.services.strategies.CalculadoraCustoStrategy;

import java.math.BigDecimal;

public class CalculadoraCustoUnidade implements CalculadoraCustoStrategy {

    @Override
    public String calcularValor(CalculoCustoDTO calculoCustoDTO) {

        BigDecimal valor = new BigDecimal(calculoCustoDTO.valorMaterial());
        valor = valor.multiply(new BigDecimal(calculoCustoDTO.qtd()));

        return valor.toString();
    }
}
