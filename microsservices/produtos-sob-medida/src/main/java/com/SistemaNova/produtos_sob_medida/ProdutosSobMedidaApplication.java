package com.SistemaNova.produtos_sob_medida;

import com.SistemaNova.produtos_sob_medida.clients.MaterialClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients(clients = {MaterialClient.class})
@EnableFeignClients
public class ProdutosSobMedidaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutosSobMedidaApplication.class, args);
	}

}
