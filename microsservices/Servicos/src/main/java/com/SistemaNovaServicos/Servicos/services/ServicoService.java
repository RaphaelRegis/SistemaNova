package com.SistemaNovaServicos.Servicos.services;

import java.util.List;

import com.SistemaNovaServicos.Servicos.dto.ServicoSaveDTO;
import com.SistemaNovaServicos.Servicos.dto.ServicoUpdateDTO;
import com.SistemaNovaServicos.Servicos.entities.Servico;

public interface ServicoService {
    Servico save(ServicoSaveDTO servicoSaveDTO);
    List<Servico> findAll();
    Servico findById(Integer id);
    Servico update(Integer id, ServicoUpdateDTO servicoUpdateDTO);
    Servico delete(Integer id);
    Servico deleteAllByTrabalho(Integer id_trabalho);




}
