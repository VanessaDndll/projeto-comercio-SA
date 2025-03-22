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
import com.comerciosa.backend.service.clienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private clienteService clienteService;

    @GetMapping("/buscar")
    public ResponseEntity<clienteEntity> buscarCliente(@RequestParam String nome, @RequestParam String cpf) {
        clienteEntity cliente = clienteService.buscarCliente(nome, cpf);

        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // READ
    @GetMapping
    public List<clienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    // CREATE
    @PostMapping
    public void inserir(@RequestBody clienteDTO cliente) {
        clienteService.inserir(cliente);
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
        return ResponseEntity.ok() .build();
    }

}
