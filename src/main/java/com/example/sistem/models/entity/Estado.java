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
    private String sigle;

    public Estado(){}

    public Estado(Long id, String name, String sigle) {
        this.id = id;
        this.name = name;
        this.sigle = sigle;
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

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }
}
