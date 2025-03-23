package com.comerciosa.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comerciosa.backend.entity.ContatoEntity;

public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

}
