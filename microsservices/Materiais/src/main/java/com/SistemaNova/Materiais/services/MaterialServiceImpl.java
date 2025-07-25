package com.SistemaNova.Materiais.services;

import java.util.List;

import com.SistemaNova.Materiais.entities.enums.Criterio;
import com.SistemaNova.Materiais.services.dto.CalculoCustoDTO;
import com.SistemaNova.Materiais.services.strategies.CalculadoraCusto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaNova.Materiais.dto.MaterialDTO;
import com.SistemaNova.Materiais.entities.Material;
import com.SistemaNova.Materiais.entities.enums.UnidadeMedida;
import com.SistemaNova.Materiais.repositories.MaterialRepository;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public Material save(MaterialDTO materialDTO) {
        Material material = new Material(materialDTO.nome(), materialDTO.preco(),
                UnidadeMedida.valueOf(materialDTO.unidadeMedida()));
        return materialRepository.save(material);
    }

    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Material findById(Integer id) {
        return materialRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("material_id: " + id + " não encontrado"));
    }

    @Override
    public Material update(Integer id, MaterialDTO materialDTO) {
        Material material = findById(id);

        material.setNome(materialDTO.nome());
        material.setPreco(materialDTO.preco());
        material.setUnidadeMedida(UnidadeMedida.valueOf(materialDTO.unidadeMedida()));

        return materialRepository.save(material);
    }

    @Override
    public Material delete(Integer id) {
        Material material = findById(id);

        // TO DO: adicionar codigo para excluir associacoes com produtos do catalogo

        materialRepository.delete(material);

        return material;
    }

    @Override
    public String calcularCustoMaterial(Integer idMaterial, Integer qtd, String altura, String largura, Criterio criterio) {

        Material material = findById(idMaterial);

        // calcula o valor com base no padrao strategy
        CalculoCustoDTO calculoCustoDTO = new CalculoCustoDTO(material.getPreco(), qtd, altura, largura);

        return CalculadoraCusto.calcularCusto(criterio, calculoCustoDTO);
    }

}
