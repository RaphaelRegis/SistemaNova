package com.SistemaNova.Materiais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaNova.Materiais.entities.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
    
}
