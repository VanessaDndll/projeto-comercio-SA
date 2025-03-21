package com.comerciosa.backend.dto;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.comerciosa.backend.entity.clienteEntity;

public class clienteDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String endereco;
    private List<contatoDTO> contatos;

    public clienteDTO(clienteEntity cliente) {
        BeanUtils.copyProperties(cliente, this);
    }

    public clienteDTO() {

    }

    // Getters and Setters

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
    public List<contatoDTO> getContatos() {
        return contatos;
    }
    public void setContatos(List<contatoDTO> contatos) {
        this.contatos = contatos;
    }

    
}
