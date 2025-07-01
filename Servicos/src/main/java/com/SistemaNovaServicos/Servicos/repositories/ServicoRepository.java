package com.SistemaNovaServicos.Servicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaNovaServicos.Servicos.entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    
}
