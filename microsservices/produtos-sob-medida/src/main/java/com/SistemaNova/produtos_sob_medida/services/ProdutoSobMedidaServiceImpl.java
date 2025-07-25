package com.SistemaNova.produtos_sob_medida.services;

import com.SistemaNova.produtos_sob_medida.clients.MaterialClient;
import com.SistemaNova.produtos_sob_medida.dto.CalculoValorBaseDTO;
import com.SistemaNova.produtos_sob_medida.dto.ProdutoSobMedidaSaveDTO;
import com.SistemaNova.produtos_sob_medida.dto.ProdutoSobMedidaUpdateDTO;
import com.SistemaNova.produtos_sob_medida.entities.ProdutoSobMedida;
import com.SistemaNova.produtos_sob_medida.entities.enums.Estado;
import com.SistemaNova.produtos_sob_medida.repositories.ProdutoSobMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoSobMedidaServiceImpl implements ProdutoSobMedidaService {

    @Autowired
    private ProdutoSobMedidaRepository produtoSobMedidaRepository;

    @Autowired
    private MaterialClient materialClient;

    @Override
    public ProdutoSobMedida save(ProdutoSobMedidaSaveDTO produtoSobMedidaSaveDTO) {
        ProdutoSobMedida produtoSobMedida = ProdutoSobMedida
                .builder()
                .idProduto(produtoSobMedidaSaveDTO.idProduto())
                .idTrabalho(produtoSobMedidaSaveDTO.idTrabalho())
                .altura(produtoSobMedidaSaveDTO.altura())
                .largura(produtoSobMedidaSaveDTO.largura())
                .estado(Estado.PRODUTO_PLANEJADO)
                .build();

        produtoSobMedida = calcularValor(produtoSobMedida, produtoSobMedidaSaveDTO.margemLucro());

        produtoSobMedidaRepository.save(produtoSobMedida);

        // TO DO: adicionar codigo para atualizar valor do trabalho

        return produtoSobMedida;
    }

    @Override
    public List<ProdutoSobMedida> findAll() {
        return produtoSobMedidaRepository.findAll();
    }

    @Override
    public ProdutoSobMedida findById(Integer id) {
        return produtoSobMedidaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("produto_sob_medida: " + id + " não encontrado"));
    }

    @Override
    public ProdutoSobMedida update(Integer id, ProdutoSobMedidaUpdateDTO produtoSobMedidaUpdateDTO) {
        ProdutoSobMedida produtoSobMedida = findById(id);

        produtoSobMedida.setAltura(produtoSobMedidaUpdateDTO.altura());
        produtoSobMedida.setLargura(produtoSobMedidaUpdateDTO.largura());
        produtoSobMedida.setEstado(Estado.valueOf(produtoSobMedidaUpdateDTO.estado()));

        produtoSobMedida = calcularValor(produtoSobMedida, produtoSobMedidaUpdateDTO.margemLucro());

        produtoSobMedidaRepository.save(produtoSobMedida);

        // TO DO: adicionar codigo para atualizar valor do trabalho

        return produtoSobMedida;
    }

    @Override
    public ProdutoSobMedida delete(Integer id) {
        ProdutoSobMedida produtoSobMedida = findById(id);

        produtoSobMedidaRepository.delete(produtoSobMedida);

        // TO DO: adicionar codigo para atualizar preco do trabalho

        return produtoSobMedida;
    }

    private ProdutoSobMedida calcularValor(ProdutoSobMedida produtoSobMedida, String margemLucro) {

        CalculoValorBaseDTO calculoValorBaseDTO = new CalculoValorBaseDTO(
                produtoSobMedida.getIdProduto(),
                produtoSobMedida.getAltura(),
                produtoSobMedida.getLargura()
        );

        BigDecimal valorBase = new BigDecimal(materialClient.
                calcularValorBase(calculoValorBaseDTO));

        BigDecimal valorTotal = valorBase.multiply(new BigDecimal(margemLucro));

        produtoSobMedida.setValorBase(valorBase.toString());
        produtoSobMedida.setValorTotal(valorTotal.toString());

        return produtoSobMedida;
    }

}
