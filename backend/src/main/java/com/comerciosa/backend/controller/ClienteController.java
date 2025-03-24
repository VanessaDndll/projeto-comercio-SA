package com.comerciosa.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.comerciosa.backend.dto.ClienteDTO;
import com.comerciosa.backend.entity.ClienteEntity;
import com.comerciosa.backend.service.ClienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // READ
    @GetMapping
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    // READ BY CPF
    @GetMapping("/buscar")
    public ResponseEntity<ClienteEntity> buscarCliente(@RequestParam String cpf) {

        ClienteEntity cliente = clienteService.buscarCliente(cpf);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // CREATE
    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDTO> inserir(@RequestBody ClienteDTO cliente) {
        ClienteDTO clienteSalvo = clienteService.inserir(cliente);
        return ResponseEntity.status(201).body(clienteSalvo);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(
            @PathVariable Integer id,
            @RequestBody ClienteDTO dto) {
        dto.setId(id);
        ClienteEntity updated = clienteService.atualizarCliente(dto);
        return ResponseEntity.ok(new ClienteDTO(updated));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
