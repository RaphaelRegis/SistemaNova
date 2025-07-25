package com.SistemaNova.Materiais.repositories;

import com.SistemaNova.Materiais.entities.ProdutoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoMaterialRepository extends JpaRepository<ProdutoMaterial, Integer> {

    List<ProdutoMaterial> findByIdProduto(Integer id);
}
