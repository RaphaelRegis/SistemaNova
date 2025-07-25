package com.SistemaNova.produtos_sob_medida.clients;

import com.SistemaNova.produtos_sob_medida.dto.CalculoValorBaseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient (name = "materiais-service")
public interface MaterialClient {

    @GetMapping("/api/materiais/calcularValorBase")
    String calcularValorBase(@RequestBody CalculoValorBaseDTO calculoValorBaseDTO);
}
