package com.SistemaNova.ProdutoBase.services;

import java.util.List;

import com.SistemaNova.ProdutoBase.dto.ProdutoBaseDTO;
import com.SistemaNova.ProdutoBase.entities.ProdutoBase;

public interface ProdutoBaseService {
    public ProdutoBase save(ProdutoBaseDTO produtoBaseDTO);
    public List<ProdutoBase> findAll();
    public ProdutoBase findById(Integer id);
    public ProdutoBase update(Integer id, ProdutoBaseDTO produtoBaseDTO);
    public ProdutoBase delete(Integer id);
}
