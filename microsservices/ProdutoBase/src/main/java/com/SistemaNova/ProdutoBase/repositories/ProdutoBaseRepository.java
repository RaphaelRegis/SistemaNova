package com.SistemaNova.ProdutoBase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaNova.ProdutoBase.entities.ProdutoBase;

@Repository
public interface ProdutoBaseRepository extends JpaRepository<ProdutoBase, Integer> {
    
}
