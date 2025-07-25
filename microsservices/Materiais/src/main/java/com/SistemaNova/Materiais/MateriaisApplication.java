package com.SistemaNova.Materiais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MateriaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MateriaisApplication.class, args);
	}

//	CATALOGO
//  Guarda o produto generico
//
//	MATERIAL
//  Guarda os materiais
//  guarda os relacionamentos entre produtos e materiais
//
//	PRODUTOS
//  Ao fazer o produto sob medida, o service pega o id do produto e a margem de lucro
//  Com o id do produto, pergunta aos materiais o preço que o produto fica
//  Ao pegar o valor base, multiplica pela margem de lucro do produto generico

}
