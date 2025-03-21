package com.comerciosa.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comerciosa.backend.dto.contatoDTO;
import com.comerciosa.backend.entity.contatoEntity;
import com.comerciosa.backend.repository.ContatoRepository;


@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    // READ
    public List<contatoDTO> listarContatos () {
        List<contatoEntity> contato = contatoRepository.findAll();
        return contato.stream() .map(contatoDTO::new).toList();
    }

    // CREATE
    public void inserir(contatoDTO contato) {
        contatoEntity contatoEntity = new contatoEntity(contato);
        contatoRepository.save(contatoEntity);
    }

    // UPDATE
    public contatoDTO alterar(contatoDTO contato) {
        contatoEntity contatoEntity = new contatoEntity(contato);
        return new contatoDTO(contatoRepository.save(contatoEntity));
    }

    // DELETE
    public void excluir(Integer id) {
        contatoEntity contato = contatoRepository.findById(id).get();
        contatoRepository.delete(contato);
    }

    // READ by id
    public contatoDTO buscarPorId(Integer id) {
        return new contatoDTO(contatoRepository.findById(id).get());
    }
}
