package com.comerciosa.backend.entity;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.comerciosa.backend.dto.clienteDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class clienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false, length = 14)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;
    
    private String endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<contatoEntity> contatos;

    public clienteEntity(clienteDTO cliente) {
        BeanUtils.copyProperties(cliente, this);
    }

    public clienteEntity() {
        
    }

// getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<contatoEntity> getContatos() {
        return contatos;
    }

    public void setContatos(List<contatoEntity> contatos) {
        this.contatos = contatos;
    } 

    
}
