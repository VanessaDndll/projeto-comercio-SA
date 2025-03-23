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

import com.comerciosa.backend.dto.clienteDTO;
import com.comerciosa.backend.entity.clienteEntity;
import com.comerciosa.backend.service.ClienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Bucando cliente pelo cpf
    @GetMapping("/buscar")
    public ResponseEntity<clienteEntity> buscarCliente(@RequestParam String cpf) {
        
        clienteEntity cliente = clienteService.buscarCliente(cpf);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Cadastrar cliente
    @PostMapping("/cadastrar")
    public ResponseEntity<clienteDTO> inserir(@RequestBody clienteDTO cliente) {
        clienteDTO clienteSalvo = clienteService.inserir(cliente);
        return ResponseEntity.status(201).body(clienteSalvo);
    }


    // READ
    @GetMapping
    public List<clienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    // UPDATE
    @PutMapping
    public clienteDTO alterar(@RequestBody clienteDTO cliente) {
        return clienteService.alterar(cliente);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
