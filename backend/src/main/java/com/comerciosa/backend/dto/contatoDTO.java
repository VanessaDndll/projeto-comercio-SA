package com.comerciosa.backend.dto;

import org.springframework.beans.BeanUtils;

import com.comerciosa.backend.entity.clienteEntity;
import com.comerciosa.backend.entity.contatoEntity;

public class contatoDTO {
    private Integer id;
    private clienteEntity cliente;
    private String tipo;
    private String valor;
    private String observacao;

    public contatoDTO(contatoEntity contato) {
        BeanUtils.copyProperties(contato, this);
    }

    public contatoDTO() {
        
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

    public clienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(clienteEntity cliente) {
        this.cliente = cliente;
    }
    
}
