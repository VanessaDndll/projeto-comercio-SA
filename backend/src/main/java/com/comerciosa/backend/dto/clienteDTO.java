package com.comerciosa.backend.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// import org.springframework.beans.BeanUtils;

import com.comerciosa.backend.entity.ClienteEntity;

public class ClienteDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String endereco;
    private List<ContatoDTO> contatos = new ArrayList<>();

    public ClienteDTO(ClienteEntity cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.endereco = cliente.getEndereco();
        this.contatos = (cliente.getContatos() != null) ? cliente.getContatos().stream().map(ContatoDTO::new).collect(Collectors.toList()) : new ArrayList<>();
    }


    public ClienteDTO() {}

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
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public List<ContatoDTO> getContatos() {
        return contatos;
    }
    public void setContato(List<ContatoDTO> contatos) {
        this.contatos = contatos;
    }

    
}
