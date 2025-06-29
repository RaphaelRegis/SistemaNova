package com.SistemaNovaEnderecos.Enderecos.services;

import java.util.List;

import com.SistemaNovaEnderecos.Enderecos.dto.EnderecoDTO;
import com.SistemaNovaEnderecos.Enderecos.dto.DividaUpdateDTO;
import com.SistemaNovaEnderecos.Enderecos.entities.Endereco;

public interface EnderecoService {
    
    Endereco save(EnderecoDTO enderecoDTO);
    List<Endereco> findAll();
    Endereco findById(Integer id);
    Endereco update(Integer id, EnderecoDTO enderecoDTO);
    Endereco updateDivida(Integer id, DividaUpdateDTO dividaUpdateDTO);
    Endereco delete(Integer id);
}
