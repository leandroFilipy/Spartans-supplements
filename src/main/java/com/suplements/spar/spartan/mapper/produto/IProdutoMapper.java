package com.suplements.spar.spartan.mapper.produto;

import com.suplements.spar.spartan.dto.produto.ProdutoRequest;
import com.suplements.spar.spartan.dto.produto.ProdutoResponse;
import com.suplements.spar.spartan.model.Produto;

public interface IProdutoMapper {

    Produto toEntity(ProdutoRequest produtoRequest);
    ProdutoResponse toResponse(Produto produto);

}
