package com.suplements.spar.spartan.dto.produto;

public record ProdutoRequest (
        String nome,
        double preco,
        String descricao,
        double peso,
        String categoria,
        String imagemUrl,
        int quantidadeEstoque

){
}
