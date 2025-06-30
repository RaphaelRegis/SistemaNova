package com.SistemaNovaTrabalhos.Trabalhos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaNovaTrabalhos.Trabalhos.entities.Trabalho;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Integer> {
    
}
