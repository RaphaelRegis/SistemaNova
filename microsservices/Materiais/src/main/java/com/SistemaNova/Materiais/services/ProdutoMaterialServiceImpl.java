package com.SistemaNova.Materiais.services;

import com.SistemaNova.Materiais.dto.CalculoValorBaseDTO;
import com.SistemaNova.Materiais.dto.ProdutoMaterialSaveDTO;
import com.SistemaNova.Materiais.dto.ProdutoMaterialUpdateDTO;
import com.SistemaNova.Materiais.entities.ProdutoMaterial;
import com.SistemaNova.Materiais.entities.enums.Criterio;
import com.SistemaNova.Materiais.repositories.ProdutoMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoMaterialServiceImpl implements ProdutoMaterialService {

    @Autowired
    private ProdutoMaterialRepository produtoMaterialRepository;

    @Autowired
    private MaterialService materialService;

    @Override
    public ProdutoMaterial save(ProdutoMaterialSaveDTO produtoMaterialSaveDTO) {
        ProdutoMaterial produtoMaterial = ProdutoMaterial
                .builder()
                .idProduto(produtoMaterialSaveDTO.idProduto())
                .idMaterial(produtoMaterialSaveDTO.idMaterial())
                .qtd(produtoMaterialSaveDTO.qtd())
                .offsetAltura(produtoMaterialSaveDTO.offsetAltura())
                .offsetLargura(produtoMaterialSaveDTO.offsetLargura())
                .criterio(Criterio.valueOf(produtoMaterialSaveDTO.criterio()))
                .build();

        produtoMaterial = produtoMaterialRepository.save(produtoMaterial);

        // TO DO: adicionar codigo para atualizar produtos sob medida

        return produtoMaterial;
    }

    @Override
    public List<ProdutoMaterial> findAll() {
        return produtoMaterialRepository.findAll();
    }

    @Override
    public ProdutoMaterial findById(Integer id) {
        return produtoMaterialRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("produto_material: " +id+ " nao encontrado"));
    }

    @Override
    public ProdutoMaterial update(Integer id, ProdutoMaterialUpdateDTO produtoMaterialUpdateDTO) {
        ProdutoMaterial produtoMaterial = findById(id);

        produtoMaterial.setQtd(produtoMaterialUpdateDTO.qtd());
        produtoMaterial.setOffsetAltura(produtoMaterialUpdateDTO.offsetAltura());
        produtoMaterial.setOffsetLargura(produtoMaterialUpdateDTO.offsetLargura());
        produtoMaterial.setCriterio(Criterio.valueOf(produtoMaterialUpdateDTO.criterio()));

        produtoMaterial = produtoMaterialRepository.save(produtoMaterial);

        // TO DO: adicionar codigo para atualizar produtos sob medida

        return produtoMaterial;
    }

    @Override
    public ProdutoMaterial delete(Integer id) {
        ProdutoMaterial produtoMaterial = findById(id);

        produtoMaterialRepository.delete(produtoMaterial);

        // TO DO: adicionar codigo para atualizar produtos sob medida

        return produtoMaterial;
    }

    @Override
    public String calcularValorBase(CalculoValorBaseDTO calculoValorBaseDTO) {
        BigDecimal valorBase = new BigDecimal("0.0");

        // pega todos os produtos_materiais com base no produto
        List<ProdutoMaterial> produtosMateriais = produtoMaterialRepository
                .findByIdProduto(calculoValorBaseDTO.idProduto());

        // percorre fazendo os calculos
        for(ProdutoMaterial produtoMaterial: produtosMateriais) {
            System.out.println("VALOR ATUAL: " +valorBase);

            // tira o offset da altura e largura
            BigDecimal altura = new BigDecimal(calculoValorBaseDTO.altura());
            altura = altura.subtract(new BigDecimal(produtoMaterial.getOffsetAltura()));

            BigDecimal largura = new BigDecimal(calculoValorBaseDTO.largura());
            largura = largura.subtract(new BigDecimal(produtoMaterial.getOffsetLargura()));

            // pergunta o valor para o materialservice
            valorBase = valorBase
                    .add(new BigDecimal(materialService.calcularCustoMaterial(
                            produtoMaterial.getIdMaterial(),
                            produtoMaterial.getQtd(),
                            altura.toString(),
                            largura.toString(),
                            produtoMaterial.getCriterio()
                    )));
        }

        return valorBase.toString();
    }
}
