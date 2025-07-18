package com.SistemaNovaTrabalhos.Trabalhos.entities;

import java.time.LocalDate;

import com.SistemaNovaTrabalhos.Trabalhos.entities.enums.Estado;

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
public class Trabalho {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_trabalho;
    private Estado estado;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private String valorTotal;
    private Integer id_endereco;
    
    public Trabalho(Integer id_endereco) {
        this.estado = Estado.NEGOCIACAO;
        this.valorTotal = "0.0";
        this.id_endereco = id_endereco;
    }

    


}
