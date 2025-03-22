package com.comerciosa.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comerciosa.backend.entity.clienteEntity;

public interface clienteRepository extends JpaRepository<clienteEntity, Integer>{
    Optional<clienteEntity> findByNomeAndCpf(String nome, String cpf);

}
