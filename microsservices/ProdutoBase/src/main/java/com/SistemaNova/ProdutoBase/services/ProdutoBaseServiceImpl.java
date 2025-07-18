package com.SistemaNova.ProdutoBase.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaNova.ProdutoBase.dto.ProdutoBaseDTO;
import com.SistemaNova.ProdutoBase.entities.ProdutoBase;
import com.SistemaNova.ProdutoBase.entities.enums.Categoria;
import com.SistemaNova.ProdutoBase.repositories.ProdutoBaseRepository;

@Service
public class ProdutoBaseServiceImpl implements ProdutoBaseService {

    @Autowired
    private ProdutoBaseRepository produtoBaseRepository;

    @Override
    public ProdutoBase save(ProdutoBaseDTO produtoBaseDTO) {
        ProdutoBase produtoBase = new ProdutoBase(produtoBaseDTO.nome(), Categoria.valueOf(produtoBaseDTO.categoria()));

        return produtoBaseRepository.save(produtoBase);
    }

    @Override
    public List<ProdutoBase> findAll() {
        return produtoBaseRepository.findAll();
    }

    @Override
    public ProdutoBase findById(Integer id) {
        return produtoBaseRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("produto_base_id: " + id + " não encontrado"));
    }

    @Override
    public ProdutoBase update(Integer id, ProdutoBaseDTO produtoBaseDTO) {
        ProdutoBase produtoBase = findById(id);

        produtoBase.setNome(produtoBaseDTO.nome());
        produtoBase.setCategoria(Categoria.valueOf(produtoBaseDTO.categoria()));

        return produtoBaseRepository.save(produtoBase);
    }

    @Override
    public ProdutoBase delete(Integer id) {
        ProdutoBase produtoBase = findById(id);

        // ADICIONAR LOGICA PARA EXCLUIR TODAS RELACOES COM MATERIAIS E PRODUTOS_CALCULADOS

        produtoBaseRepository.delete(produtoBase);

        return produtoBase;
    }
    
}
