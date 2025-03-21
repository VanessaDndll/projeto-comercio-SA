package com.comerciosa.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comerciosa.backend.dto.clienteDTO;
import com.comerciosa.backend.entity.clienteEntity;
import com.comerciosa.backend.repository.clienteRepository;

@Service
public class ClienteService {

    @Autowired
    private clienteRepository clienteRepository;
    
    @Transactional
    public clienteEntity buscarCliente(String cpf) {
        return clienteRepository.findByCpfWithContatos(cpf)
                .orElse(null);
    }


    // public clienteEntity buscarCliente(Strg cpf) {
    //     return clienteRepository.findByCpf(cpf)
    //             .orElse(null);
    // }

    // READ
    public List<clienteDTO> listarClientes () {
        List<clienteEntity> cliente = clienteRepository.findAll();
        return cliente.stream().map(clienteDTO::new).toList();
    }

    // CREATE
    public void inserir(clienteDTO cliente) {
        clienteEntity clienteEntity = new clienteEntity(cliente);
        clienteRepository.save(clienteEntity);
    }

    // UPDATE
    public clienteDTO alterar(clienteDTO cliente) {
        clienteEntity clienteEntity = new clienteEntity(cliente);
        return new clienteDTO(clienteRepository.save(clienteEntity));
    }

    // DELETE
    public void excluir(Integer id) {
        clienteEntity cliente = clienteRepository.findById(id).get();
        clienteRepository.delete(cliente);
    }

    // READ by id
    public clienteDTO buscarPorId(Integer id) {
        return new clienteDTO(clienteRepository.findById(id).get());
    }
}