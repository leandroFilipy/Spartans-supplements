package com.suplements.spar.spartan.dto.Carrinho;

public record ItemResponse(
        Long itemId,
        Long produtoId,
        String nome,
        Double preco,
        Integer quantidade
) {}