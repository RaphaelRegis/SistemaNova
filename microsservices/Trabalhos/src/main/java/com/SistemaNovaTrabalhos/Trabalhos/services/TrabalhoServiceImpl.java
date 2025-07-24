package com.SistemaNovaTrabalhos.Trabalhos.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaNovaTrabalhos.Trabalhos.dto.TrabalhoSaveDTO;
import com.SistemaNovaTrabalhos.Trabalhos.dto.TrabalhoValorDTO;
import com.SistemaNovaTrabalhos.Trabalhos.entities.Trabalho;
import com.SistemaNovaTrabalhos.Trabalhos.entities.enums.Estado;
import com.SistemaNovaTrabalhos.Trabalhos.repositories.TrabalhoRepository;

@Service
public class TrabalhoServiceImpl implements TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    @Override
    public Trabalho save(TrabalhoSaveDTO trabalhoDTO) {
        Trabalho trabalho = new Trabalho(trabalhoDTO.id_endereco());

        return trabalhoRepository.save(trabalho);
    }

    @Override
    public Trabalho findById(Integer id) {
        return trabalhoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("trabalho_id: " + id + " não encontrado"));
    }

    @Override
    public List<Trabalho> findAll() {
        return trabalhoRepository.findAll();
    }

    @Override
    public Trabalho updateValor(Integer id, TrabalhoValorDTO trabalhoValorDTO) {
        Trabalho trabalho = findById(id);

        // o valor so pode ser mudado se o estado foi diferente de FINALIZADO
//        if (trabalho.getEstado().equals(Estado.FINALIZADO)) {
//            throw new RuntimeException("Impossivel atualizar valor! TRABALHO já FINALIZADO");
//        }

        BigDecimal valorAtual = new BigDecimal(trabalho.getValorTotal());
        BigDecimal novoValor = valorAtual.add(new BigDecimal(trabalhoValorDTO.valor()));

        trabalho.setValorTotal(novoValor.toString());

        // TO DO: adicionar codigo para atualizar divida do endereco


        return trabalhoRepository.save(trabalho);
    }

    @Override
    public Trabalho updateEstado(Integer id) {
        Trabalho trabalho = findById(id);
        Estado novoEstado = null;

        // atualiza estado
        if (!(trabalho.getEstado().equals(Estado.FINALIZADO))) {
            novoEstado = trabalho.getEstado().proximo();

        } else {
            throw new RuntimeException("Trabalho com estado FINALIZADO!");

        }
        trabalho.setEstado(novoEstado);

        // atualiza os campos de acordo
        if (trabalho.getEstado().equals(Estado.EM_ANDAMENTO)) {
            trabalho.setData_inicio(LocalDate.now());

        } else if (trabalho.getEstado().equals(Estado.FINALIZADO)) {
            trabalho.setData_fim(LocalDate.now());

        }

        return trabalhoRepository.save(trabalho);
    }

    @Override
    public Trabalho delete(Integer id) {
        Trabalho trabalho = findById(id);
        
        // o trabalho so pode ser excluido se estiver com estado NEGOCIACAO OU FINALIZADO
//        Estado estado = trabalho.getEstado();
//        if (!(estado.equals(Estado.NEGOCIACAO) || estado.equals(Estado.FINALIZADO))) {
//            throw new RuntimeException("Impossivel excluir o trabalho!");
//        }

        // TO DO: adicionar codigo para excluir servicos associados

        trabalhoRepository.delete(trabalho);

        return trabalho;
    }

}
