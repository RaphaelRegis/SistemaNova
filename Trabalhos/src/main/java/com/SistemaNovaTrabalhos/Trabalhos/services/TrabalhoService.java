package com.SistemaNovaTrabalhos.Trabalhos.services;

import java.util.List;

import com.SistemaNovaTrabalhos.Trabalhos.dto.TrabalhoSaveDTO;
import com.SistemaNovaTrabalhos.Trabalhos.dto.TrabalhoValorDTO;
import com.SistemaNovaTrabalhos.Trabalhos.entities.Trabalho;

public interface TrabalhoService {
    Trabalho save(TrabalhoSaveDTO trabalhoDTO);
    Trabalho findById(Integer id);
    List<Trabalho> findAll();
    Trabalho updateValor(Integer id, TrabalhoValorDTO trabalhoValorDTO);
    Trabalho updateEstado(Integer id);
    Trabalho delete(Integer id);
}
