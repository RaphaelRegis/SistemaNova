package com.SistemaNovaServicos.Servicos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaNovaServicos.Servicos.dto.ServicoSaveDTO;
import com.SistemaNovaServicos.Servicos.dto.ServicoUpdateDTO;
import com.SistemaNovaServicos.Servicos.entities.Servico;
import com.SistemaNovaServicos.Servicos.entities.enums.Estado;
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

        // o SERVICO so eh atualizado se seu estado for diferente de ENTREGUE ou CANCELADO
        if (servico.getEstado().equals(Estado.ENTREGUE) || servico.getEstado().equals(Estado.CANCELADO)) {
            throw new RuntimeException("Impossivel atualizar SERVICO! Motivo: SERVICO" + servico.getEstado());
        }

        servico.setValor(servicoUpdateDTO.valor());
        servico.setDescricao(servicoUpdateDTO.descricao());

        // atualiza o estado se for necessario
        if (servicoUpdateDTO.estado() != null) {
            Estado novoEstado = Estado.valueOf(servicoUpdateDTO.estado());
            servico = updateEstado(servico, novoEstado);
        }

        // ADICIONAR CODIGO PARA ATUALIZAR VALOR DO TRABALHO

        return servicoRepository.save(servico);
    }

    @Override
    public Servico delete(Integer id) {
        Servico servico = findById(id);

        if (servico.getEstado().equals(Estado.ENTREGUE)) {
            throw new RuntimeException("Impossivel excluir: servico com id (" + id + ") ja entregue!");
        }

        servicoRepository.delete(servico);

        return servico;
    }

    @Override
    public Servico deleteAllByTrabalho(Integer id_trabalho) {
        // ADICIONAR CODIGO PARA DELETAR TODOS COM BASE NO ID DO TRABALHO

        return null;
    }

    public Servico updateEstado(Servico servico, Estado novoEstado) {
        if (novoEstado.equals(Estado.ENTREGUE)) {
            servico.setEstado(servico.getEstado().entregar());

        } else if (novoEstado.equals(Estado.CANCELADO)) {
            servico.setEstado(servico.getEstado().cancelar());

        }

        return servico;
    }
}
