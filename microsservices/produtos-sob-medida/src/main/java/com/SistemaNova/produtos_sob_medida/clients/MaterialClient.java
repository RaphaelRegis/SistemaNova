package com.SistemaNova.produtos_sob_medida.clients;

import com.SistemaNova.produtos_sob_medida.dto.CalculoValorBaseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient (value = "materiais-service", url="http://localhost:8083/api/produtos-materiais")
@FeignClient (name = "materiais-service")
public interface MaterialClient {

    //@RequestMapping(method = RequestMethod.POST, value="/calcularValorBase")
    @GetMapping("api/produtos-materiais/calcularValorBase")
    String calcularValorBase(@RequestBody CalculoValorBaseDTO calculoValorBaseDTO);
}
