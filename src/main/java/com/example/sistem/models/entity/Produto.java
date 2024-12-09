package com.example.sistem.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String codigoBarra;
    private String unidadeMedida;
    private Double estoque;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Pratileira pratileira;

    public Produto(){}

    public Produto(Long id, String nome, String codigoBarra, String unidadeMedida, Double estoque, Pratileira pratileira) {
        this.id = id;
        this.nome = nome;
        this.codigoBarra = codigoBarra;
        this.unidadeMedida = unidadeMedida;
        this.estoque = estoque;
        this.pratileira = pratileira;
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

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public Pratileira getPratileira() {
        return pratileira;
    }

    public void setPratileira(Pratileira pratileira) {
        this.pratileira = pratileira;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(codigoBarra, produto.codigoBarra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoBarra);
    }
}
