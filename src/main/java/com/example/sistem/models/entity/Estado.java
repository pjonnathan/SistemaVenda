package com.example.sistem.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_estado")
public class Estado implements Serializable {
    private static final long  serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String sigla;

    public Estado(){}

    public Estado(Long id, String name, String sigla) {
        this.id = id;
        this.name = name;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
