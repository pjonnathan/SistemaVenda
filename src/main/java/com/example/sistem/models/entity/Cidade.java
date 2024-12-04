package com.example.sistem.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_cidade")
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String CEP;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Cidade(){}

    public Cidade(Long id, String name, String CEP, Estado estado) {
        this.id = id;
        this.name = name;
        this.CEP = CEP;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Estado getEstado() {
        return estado;
    }

}
