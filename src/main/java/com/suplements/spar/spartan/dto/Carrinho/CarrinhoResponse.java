package com.suplements.spar.spartan.dto.Carrinho;

import java.util.List;

public record CarrinhoResponse(
        Long id,
        Long usuarioId,
        List<ItemResponse> itens,
        Double total
) {}
