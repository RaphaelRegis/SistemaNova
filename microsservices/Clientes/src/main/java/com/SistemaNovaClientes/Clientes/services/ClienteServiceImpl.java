package com.SistemaNovaClientes.Clientes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaNovaClientes.Clientes.dto.ClienteDTO;
import com.SistemaNovaClientes.Clientes.entities.Cliente;
import com.SistemaNovaClientes.Clientes.entities.enums.Tipo_Pessoa;
import com.SistemaNovaClientes.Clientes.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(ClienteDTO clienteDTO) {

        Cliente novoCliente = new Cliente(clienteDTO.nome(), clienteDTO.id_fiscal(), clienteDTO.celular());

        return clienteRepository.save(novoCliente);
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("cliente_id: " + id + " não encontrado"));
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente update(Integer id, ClienteDTO clienteDTO) {
        Cliente cliente = findById(id);

        cliente.setNome(clienteDTO.nome());
        cliente.setId_fiscal(clienteDTO.id_fiscal());
        cliente.setCelular(clienteDTO.celular());

        if (clienteDTO.id_fiscal().length() > 11) {
            cliente.setTipo_Pessoa(Tipo_Pessoa.CNPJ);
        } else {
            cliente.setTipo_Pessoa(Tipo_Pessoa.CPF);
        }

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente delete(Integer id) {

        Cliente cliente = findById(id);

        // TO DO: codigo para apagar todos os enderecos

        clienteRepository.delete(cliente);

        return cliente;
    }

}
