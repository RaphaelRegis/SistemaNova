package com.SistemaNovaEnderecos.Enderecos.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaNovaEnderecos.Enderecos.dto.EnderecoDTO;
import com.SistemaNovaEnderecos.Enderecos.dto.DividaUpdateDTO;
import com.SistemaNovaEnderecos.Enderecos.entities.Endereco;
import com.SistemaNovaEnderecos.Enderecos.repositories.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public Endereco save(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(
                enderecoDTO.cidade(),
                enderecoDTO.logradouro(),
                enderecoDTO.numero(),
                enderecoDTO.id_cliente());

        return enderecoRepository.save(endereco);
    }

    @Override
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco findById(Integer id) {
        return enderecoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("endereco_id: " + id + " não encontrado"));
    }

    @Override
    public Endereco update(Integer id, EnderecoDTO enderecoDTO) {
        Endereco endereco = findById(id);

        endereco.setCidade(enderecoDTO.cidade());
        endereco.setLogradouro(enderecoDTO.logradouro());
        endereco.setNumero(enderecoDTO.numero());
        
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco updateDivida(Integer id, DividaUpdateDTO dividaUpdateDTO) {
        Endereco endereco = findById(id);

        BigDecimal valorAtual = new BigDecimal(endereco.getDivida());
        BigDecimal novoValor = valorAtual.add(new BigDecimal(dividaUpdateDTO.valor()));

        endereco.setDivida(novoValor.toString());

        return enderecoRepository.save(endereco);
    }
    
    @Override
    public Endereco delete(Integer id) {
        Endereco endereco = findById(id);
        enderecoRepository.delete(endereco);

        return endereco;
    }

    

}
