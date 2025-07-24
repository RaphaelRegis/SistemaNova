package com.SistemaNova.catalogo_produtos.services;

import com.SistemaNova.catalogo_produtos.dto.ProdutoDTO;
import com.SistemaNova.catalogo_produtos.entities.Produto;

import java.util.List;

public interface ProdutoService {

    Produto save(ProdutoDTO produtoDTO);
    List<Produto> findAll();
    Produto findById(Integer id);
    Produto update(Integer id, ProdutoDTO produtoDTO);
    Produto delete(Integer id);





}
