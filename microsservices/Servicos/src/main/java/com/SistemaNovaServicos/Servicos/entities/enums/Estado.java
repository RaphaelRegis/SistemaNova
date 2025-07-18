package com.SistemaNovaServicos.Servicos.entities.enums;

public enum Estado {
    ATIVO,
    ENTREGUE,
    CANCELADO;

    public Estado entregar(){
        Estado novoEstado = this;

        if (this.equals(Estado.ATIVO)) {
            novoEstado = Estado.ENTREGUE;
        }

        return novoEstado;
    }

    public Estado cancelar(){
        Estado novoEstado = this;

        if (this.equals(Estado.ATIVO)) {
            novoEstado = Estado.CANCELADO;
        }

        return novoEstado;
    }
}
