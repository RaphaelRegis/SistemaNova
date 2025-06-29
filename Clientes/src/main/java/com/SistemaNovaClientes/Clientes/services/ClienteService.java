package com.SistemaNovaClientes.Clientes.services;

import java.util.List;

import com.SistemaNovaClientes.Clientes.dto.ClienteDTO;
import com.SistemaNovaClientes.Clientes.entities.Cliente;

public interface ClienteService {
    Cliente save(ClienteDTO clienteDTO);
    Cliente findById(Integer id);
    List<Cliente> findAll();
    Cliente update(Integer id, ClienteDTO clienteDTO);
    Cliente delete(Integer id);
}
