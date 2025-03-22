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
import org.springframework.web.bind.annotation.RestController;

import com.comerciosa.backend.dto.contatoDTO;
import com.comerciosa.backend.service.ContatoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    // READ
    @GetMapping
    public List<contatoDTO> listarContatos() {
        return contatoService.listarContatos();
    }

    // CREATE
    @PostMapping
    public void inserir(@RequestBody contatoDTO contato) {
        contatoService.inserir(contato);
    }

    // UPDATE
    @PutMapping
    public contatoDTO alterar(@RequestBody contatoDTO contato) {
        return contatoService.alterar(contato);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        contatoService.excluir(id);
        return ResponseEntity.ok() .build();
    }

}
