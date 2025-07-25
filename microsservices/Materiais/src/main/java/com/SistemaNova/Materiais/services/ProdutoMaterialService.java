package com.SistemaNova.Materiais.services;

import com.SistemaNova.Materiais.dto.CalculoValorBaseDTO;
import com.SistemaNova.Materiais.dto.ProdutoMaterialSaveDTO;
import com.SistemaNova.Materiais.dto.ProdutoMaterialUpdateDTO;
import com.SistemaNova.Materiais.entities.ProdutoMaterial;

import java.util.List;

public interface ProdutoMaterialService {
    ProdutoMaterial save(ProdutoMaterialSaveDTO produtoMaterialSaveDTO);
    List<ProdutoMaterial> findAll();
    ProdutoMaterial findById(Integer id);
    ProdutoMaterial update(Integer id, ProdutoMaterialUpdateDTO produtoMaterialUpdateDTO);
    ProdutoMaterial delete(Integer id);
    String calcularValorBase(CalculoValorBaseDTO calculoValorBaseDTO);
}
