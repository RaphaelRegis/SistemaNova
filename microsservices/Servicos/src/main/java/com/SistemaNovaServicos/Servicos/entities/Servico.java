package com.SistemaNovaServicos.Servicos.entities;

import com.SistemaNovaServicos.Servicos.entities.enums.Estado;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String valor;

    private String descricao;
    private Estado estado;

    private Integer id_trabalho;

    public Servico(String valor, String descricao, Integer id_trabalho) {
        this.valor = valor;
        this.descricao = descricao;
        this.id_trabalho = id_trabalho;
        this.estado = Estado.ATIVO;
    }

}
