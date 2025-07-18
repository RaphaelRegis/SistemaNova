package com.SistemaNova.Materiais.services;

import java.util.List;

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

        // ADICIONAR CODIGO PARA ATUALIZAR PRODUTO_MATERIAL

        return materialRepository.save(material);
    }

    @Override
    public Material delete(Integer id) {
        Material material = findById(id);

        // ADICIONAR LOGICA DE EXCLUSAO DO MATERIAL (MATERIAL soh pode ser excluido caso nao esteja em PRODUTO_MATERIAL)

        materialRepository.delete(material);

        return material;
    }

}
