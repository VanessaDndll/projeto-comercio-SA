package com.comerciosa.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comerciosa.backend.dto.ClienteDTO;
import com.comerciosa.backend.dto.ContatoDTO;
import com.comerciosa.backend.entity.ClienteEntity;
import com.comerciosa.backend.entity.ContatoEntity;
import com.comerciosa.backend.repository.clienteRepository;
import com.comerciosa.backend.repository.ContatoRepository;

@Service
public class ClienteService {

    @Autowired
    private clienteRepository clienteRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Transactional
    public ClienteDTO inserir(ClienteDTO dto) {
        final ClienteEntity cliente = new ClienteEntity(dto);
        ClienteEntity savedCliente = clienteRepository.save(cliente);

        if (dto.getContatos() != null && !dto.getContatos().isEmpty()) {
            List<ContatoEntity> contatos = dto.getContatos().stream().map(ctdto -> {
                ContatoEntity contato = new ContatoEntity(ctdto);
                contato.setCliente(savedCliente);
                return contato;
            }).collect(Collectors.toList());
            contatoRepository.saveAll(contatos);
            cliente.setContato(contatos);
        } else {
            System.out.println("Contato is null. gotta fix it");
        }
        return new ClienteDTO(savedCliente);
    }

    // Bucando cliente por cpf
    @Transactional
    public ClienteEntity buscarCliente(String cpf) {
        return clienteRepository.findByCpfWithContatos(cpf)
                .orElse(null);
    }

    // READ
    public List<ClienteDTO> listarClientes() {
        List<ClienteEntity> cliente = clienteRepository.findAll();
        return cliente.stream().map(ClienteDTO::new).toList();
    }

    // UPDATE
    @Transactional
    public ClienteEntity atualizarCliente(ClienteDTO dto) {
        ClienteEntity existing = clienteRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        existing.setNome(dto.getNome());
        existing.setCpf(dto.getCpf());
        existing.setDataNascimento(dto.getDataNascimento());
        existing.setEndereco(dto.getEndereco());

        contatoRepository.deleteAll(existing.getContatos());

        existing.getContatos().clear();

        if (dto.getContatos() != null) {
            for (ContatoDTO contatoDto : dto.getContatos()) {
                ContatoEntity contato = new ContatoEntity(contatoDto);
                contato.setCliente(existing);
                existing.getContatos().add(contato);
            }
        }

        return clienteRepository.save(existing);
    }

    // DELETE
    public void excluir(Integer id) {
        ClienteEntity cliente = clienteRepository.findById(id).get();
        List<ContatoEntity> contatos = cliente.getContatos();

        for (ContatoEntity contato : contatos) {
            contatoRepository.delete(contato);
        }

        clienteRepository.delete(cliente);
    }
}