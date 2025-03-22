package com.comerciosa.backend.entity;

import org.springframework.beans.BeanUtils;

import com.comerciosa.backend.dto.contatoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato")
public class contatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String valor;

    private String observacao;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private clienteEntity cliente;


    public contatoEntity(contatoDTO contato) {
        BeanUtils.copyProperties(contato, this);
    }

    public contatoEntity() {}

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
