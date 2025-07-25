package com.SistemaNova.Materiais.services.strategies;

import com.SistemaNova.Materiais.entities.enums.Criterio;
import com.SistemaNova.Materiais.services.dto.CalculoCustoDTO;
import com.SistemaNova.Materiais.services.strategies.impl.CalculadoraCustoAltura;
import com.SistemaNova.Materiais.services.strategies.impl.CalculadoraCustoAlturaLargura;
import com.SistemaNova.Materiais.services.strategies.impl.CalculadoraCustoLargura;
import com.SistemaNova.Materiais.services.strategies.impl.CalculadoraCustoUnidade;

import java.util.HashMap;
import java.util.Map;

public class CalculadoraCusto {

    public static String calcularCusto(Criterio criterio, CalculoCustoDTO calculoCustoDTO) {
        Map<Criterio, CalculadoraCustoStrategy> calculadoras = new HashMap<>();

        calculadoras.put(Criterio.UNIDADE, new CalculadoraCustoUnidade());
        calculadoras.put(Criterio.ALTURA, new CalculadoraCustoAltura());
        calculadoras.put(Criterio.LARGURA, new CalculadoraCustoLargura());
        calculadoras.put(Criterio.ALTURA_LARGURA, new CalculadoraCustoAlturaLargura());

        CalculadoraCustoStrategy calculadora = calculadoras.get(criterio);


        return calculadora.calcularValor(calculoCustoDTO);

    }
}
