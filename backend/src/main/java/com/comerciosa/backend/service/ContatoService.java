package com.comerciosa.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comerciosa.backend.dto.ContatoDTO;
import com.comerciosa.backend.entity.ContatoEntity;
import com.comerciosa.backend.repository.ContatoRepository;


@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    // READ
    public List<ContatoDTO> listarContatos () {
        List<ContatoEntity> contato = contatoRepository.findAll();
        return contato.stream() .map(ContatoDTO::new).toList();
    }

    // CREATE
    public void inserir(ContatoDTO contato) {
        ContatoEntity ContatoEntity = new ContatoEntity(contato);
        contatoRepository.save(ContatoEntity);
    }

    // UPDATE
    public ContatoDTO alterar(ContatoDTO contato) {
        ContatoEntity ContatoEntity = new ContatoEntity(contato);
        return new ContatoDTO(contatoRepository.save(ContatoEntity));
    }

    // DELETE
    public void excluir(Integer id) {
        ContatoEntity contato = contatoRepository.findById(id).get();
        contatoRepository.delete(contato);
    }

    // READ by id
    public ContatoDTO buscarPorId(Integer id) {
        return new ContatoDTO(contatoRepository.findById(id).get());
    }
}
