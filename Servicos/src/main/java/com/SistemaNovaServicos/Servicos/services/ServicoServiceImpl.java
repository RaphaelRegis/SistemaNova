package com.SistemaNovaServicos.Servicos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaNovaServicos.Servicos.dto.ServicoSaveDTO;
import com.SistemaNovaServicos.Servicos.dto.ServicoUpdateDTO;
import com.SistemaNovaServicos.Servicos.entities.Servico;
import com.SistemaNovaServicos.Servicos.repositories.ServicoRepository;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public Servico save(ServicoSaveDTO servicoSaveDTO) {
        Servico servico = new Servico(servicoSaveDTO.valor(), servicoSaveDTO.descricao(), servicoSaveDTO.id_trabalho());

        return servicoRepository.save(servico);
    }

    @Override
    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    @Override
    public Servico findById(Integer id) {
        return servicoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("cliente_id: " + id + " não encontrado"));
    }

    @Override
    public Servico update(Integer id, ServicoUpdateDTO servicoUpdateDTO) {
        Servico servico = findById(id);

        servico.setValor(servicoUpdateDTO.valor());
        servico.setDescricao(servicoUpdateDTO.descricao());

        //ADICIONAR CODIGO PARA ATUALIZAR VALOR DO TRABALHO
        
        return servicoRepository.save(servico);
    }

    @Override
    public Servico delete(Integer id) {
        Servico servico = findById(id);
        
        servicoRepository.delete(servico);

        return servico;
    }

}
