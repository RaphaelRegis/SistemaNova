package com.SistemaNova.produtos_sob_medida.repositories;

import com.SistemaNova.produtos_sob_medida.entities.ProdutoSobMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoSobMedidaRepository extends JpaRepository<ProdutoSobMedida, Integer> {
}
