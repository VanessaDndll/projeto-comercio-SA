package com.comerciosa.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comerciosa.backend.entity.ClienteEntity;

public interface clienteRepository extends JpaRepository<ClienteEntity, Integer> {
    @Query("SELECT c FROM ClienteEntity c LEFT JOIN FETCH c.contatos WHERE c.cpf = :cpf")
    Optional<ClienteEntity> findByCpfWithContatos(@Param("cpf") String cpf);
}
