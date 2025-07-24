package com.SistemaNova.catalogo_produtos.services;

import com.SistemaNova.catalogo_produtos.dto.ProdutoDTO;
import com.SistemaNova.catalogo_produtos.entities.Produto;
import com.SistemaNova.catalogo_produtos.entities.enums.TipoProduto;
import com.SistemaNova.catalogo_produtos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoMaterialImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto save(ProdutoDTO produtoDTO) {

        Produto produto = Produto
                .builder()
                .nome(produtoDTO.nome())
                .margemLucro(produtoDTO.margemLucro())
                .tipoProduto(TipoProduto.valueOf(produtoDTO.tipoProduto()))
                .build();

        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(Integer id) {
        return produtoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("produto_id: " + id + " não encontrado"));
    }

    @Override
    public Produto update(Integer id, ProdutoDTO produtoDTO) {
        Produto produto = findById(id);

        produto.setNome(produtoDTO.nome());
        produto.setMargemLucro(produtoDTO.margemLucro());
        produto.setTipoProduto(TipoProduto.valueOf(produtoDTO.tipoProduto()));

        // TO DO: adicionar codigo para atualizar preco dos produtos sob medida

        return produtoRepository.save(produto);
    }

    @Override
    public Produto delete(Integer id) {
        Produto produto = findById(id);

        // TO DO: adicionar codigo para excluir todas as associacoes com materiais

        // TO DO: adicionar codigo para excluir todos os produtos sob medida

        produtoRepository.delete(produto);

        return produto;
    }
}
