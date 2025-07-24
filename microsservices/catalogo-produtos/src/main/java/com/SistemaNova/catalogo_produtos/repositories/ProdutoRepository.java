package com.SistemaNova.catalogo_produtos.repositories;

import com.SistemaNova.catalogo_produtos.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
