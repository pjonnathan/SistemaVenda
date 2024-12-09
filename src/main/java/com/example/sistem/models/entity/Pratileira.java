package com.example.sistem.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pratileira implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "movel_id")
    private Movel movel;

    @OneToMany(mappedBy = "pratileira")
    private List<Produto> list = new ArrayList<>();

    public Pratileira() {
    }

    public Pratileira(Long id, String nome, Movel movel) {
        this.id = id;
        this.nome = nome;
        this.movel = movel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Movel getMovel() {
        return movel;
    }

    public void setMovel(Movel movel) {
        this.movel = movel;
    }
}
