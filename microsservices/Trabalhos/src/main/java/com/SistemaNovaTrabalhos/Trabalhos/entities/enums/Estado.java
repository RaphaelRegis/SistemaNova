package com.SistemaNovaTrabalhos.Trabalhos.entities.enums;

public enum Estado {
    NEGOCIACAO, //o trabalho ainda esta sendo planejado
    EM_ANDAMENTO, //o trabalho esta em andamento
    FINALIZADO; // o trabalho foi finalizado

    public Estado proximo(){
        Estado novoEstado = this;
        Estado[] estados = Estado.values();
        int proximoIndice = this.ordinal() +1;

        if(proximoIndice < estados.length) {
            novoEstado = estados[proximoIndice];
        }

        return novoEstado;
    }
}
