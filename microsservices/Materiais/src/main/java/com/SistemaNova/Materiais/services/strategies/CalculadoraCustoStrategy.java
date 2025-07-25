package com.SistemaNova.Materiais.services.strategies;

import com.SistemaNova.Materiais.services.dto.CalculoCustoDTO;

public interface CalculadoraCustoStrategy {

    String calcularValor(CalculoCustoDTO calculoCustoDTO);

}
