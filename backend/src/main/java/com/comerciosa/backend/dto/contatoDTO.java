package com.comerciosa.backend.dto;

import org.springframework.beans.BeanUtils;

import com.comerciosa.backend.entity.ClienteEntity;
import com.comerciosa.backend.entity.ContatoEntity;

public class ContatoDTO {
    private Integer id;
    private ClienteEntity cliente;
    private String tipo;
    private String valor;
    private String observacao;

    public ContatoDTO(ContatoEntity contato) {
        BeanUtils.copyProperties(contato, this);
    }

    public ContatoDTO() {
        
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
}
