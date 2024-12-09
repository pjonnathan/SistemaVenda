package com.example.sistem.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Movel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "movel")
    private List<Pratileira> list = new ArrayList<>();

    public Movel() {
    }

    public Movel(String nome, Long id) {
        this.nome = nome;
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movel movel = (Movel) o;
        return Objects.equals(id, movel.id) && Objects.equals(nome, movel.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    public List<Pratileira> getList() {
        return list;
    }
}
