package com.comerciosa.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comerciosa.backend.entity.contatoEntity;

public interface ContatoRepository extends JpaRepository<contatoEntity, Integer> {

}
