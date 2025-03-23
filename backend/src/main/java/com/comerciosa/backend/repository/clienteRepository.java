package com.comerciosa.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comerciosa.backend.entity.clienteEntity;

public interface clienteRepository extends JpaRepository<clienteEntity, Integer> {
    @Query("SELECT c FROM clienteEntity c LEFT JOIN FETCH c.contatos WHERE c.cpf = :cpf")
    Optional<clienteEntity> findByCpfWithContatos(@Param("cpf") String cpf);
}
