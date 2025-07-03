package com.SistemaNova.Materiais.services;

import java.util.List;

import com.SistemaNova.Materiais.dto.MaterialDTO;
import com.SistemaNova.Materiais.entities.Material;

public interface MaterialService {
    public Material save(MaterialDTO materialDTO);
    public List<Material> findAll();
    public Material findById(Integer id);
    public Material update(Integer id, MaterialDTO materialDTO);
    public Material delete(Integer id);
}
