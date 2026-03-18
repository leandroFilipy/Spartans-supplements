package com.suplements.spar.spartan.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private double peso;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String imagemUrl;

    private int quantidadeEstoque;

    public Produto(String nome, double preco, String descricao, double peso, String categoria, String imagemUrl, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.peso = peso;
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
