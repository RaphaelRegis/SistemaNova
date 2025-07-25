package com.SistemaNova.produtos_sob_medida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProdutosSobMedidaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutosSobMedidaApplication.class, args);
	}

}
