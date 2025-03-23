package com.comerciosa.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comerciosa.backend.dto.clienteDTO;
import com.comerciosa.backend.dto.contatoDTO;
import com.comerciosa.backend.entity.clienteEntity;
import com.comerciosa.backend.entity.contatoEntity;
import com.comerciosa.backend.repository.clienteRepository;
import com.comerciosa.backend.repository.ContatoRepository;

@Service
public class ClienteService {

    @Autowired
    private clienteRepository clienteRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Transactional
    public clienteDTO inserir(clienteDTO dto) {
        // Create client entity from DTO
        final clienteEntity cliente = new clienteEntity(dto);
        clienteEntity savedCliente = clienteRepository.save(cliente);

        // Create and save contacts if any
        if (dto.getContato() != null && !dto.getContato().isEmpty()) {
            List<contatoEntity> contatos = dto.getContato().stream().map(ctdto -> {
                contatoEntity contato = new contatoEntity(ctdto);
                contato.setCliente(savedCliente);
                return contato;
            }).collect(Collectors.toList());
            contatoRepository.saveAll(contatos);
            cliente.setContato(contatos);
        } else {
            System.out.println("Contato is null. gotta fix it");
        }
        return new clienteDTO(savedCliente);
    }

    // Bucando cliente por cpf
    @Transactional
    public clienteEntity buscarCliente(String cpf) {
        return clienteRepository.findByCpfWithContatos(cpf)
                .orElse(null);
    }

    // READ
    public List<clienteDTO> listarClientes() {
        List<clienteEntity> cliente = clienteRepository.findAll();
        return cliente.stream().map(clienteDTO::new).toList();
    }

    // UPDATE
    @Transactional
    public clienteEntity atualizarCliente(clienteDTO dto) {
        clienteEntity existing = clienteRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        existing.setNome(dto.getNome());
        existing.setCpf(dto.getCpf());
        existing.setDataNascimento(dto.getDataNascimento());
        existing.setEndereco(dto.getEndereco());

        existing.getContato().clear();

        if (dto.getContato() != null) {
            for (contatoDTO contatoDto : dto.getContato()) {
                contatoEntity contato = new contatoEntity(contatoDto);
                contato.setCliente(existing);
                existing.getContato().add(contato);
            }
        }

        return clienteRepository.save(existing);
    }

    // DELETE
    public void excluir(Integer id) {
        clienteEntity cliente = clienteRepository.findById(id).get();
        List<contatoEntity> contatos = cliente.getContato();

        for (contatoEntity contato : contatos) {
            contatoRepository.delete(contato);
        }

        clienteRepository.delete(cliente);
    }
}