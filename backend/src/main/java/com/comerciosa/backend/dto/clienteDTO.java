package com.comerciosa.backend.dto;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// import org.springframework.beans.BeanUtils;

import com.comerciosa.backend.entity.clienteEntity;

public class clienteDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String endereco;
    private List<contatoDTO> contatos = new ArrayList<>();

    public clienteDTO(clienteEntity cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.endereco = cliente.getEndereco();
        this.contatos = (cliente.getContato() != null) ? cliente.getContato().stream().map(contatoDTO::new).collect(Collectors.toList()) : new ArrayList<>();
    }


    public clienteDTO() {}

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
    public List<contatoDTO> getContato() {
        return contatos;
    }
    public void setContato(List<contatoDTO> contatos) {
        this.contatos = contatos;
    }

    
}
