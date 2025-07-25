package com.SistemaNova.produtos_sob_medida.services;

import com.SistemaNova.produtos_sob_medida.dto.ProdutoSobMedidaSaveDTO;
import com.SistemaNova.produtos_sob_medida.dto.ProdutoSobMedidaUpdateDTO;
import com.SistemaNova.produtos_sob_medida.entities.ProdutoSobMedida;

import java.util.List;

public interface ProdutoSobMedidaService {
    ProdutoSobMedida save(ProdutoSobMedidaSaveDTO produtoSobMedidaSaveDTO);
    List<ProdutoSobMedida> findAll();
    ProdutoSobMedida findById(Integer id);
    ProdutoSobMedida update(Integer id, ProdutoSobMedidaUpdateDTO produtoSobMedidaUpdateDTO);
    ProdutoSobMedida delete(Integer id);

}
