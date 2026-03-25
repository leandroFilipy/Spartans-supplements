package com.suplements.spar.spartan.service.produto;

import com.suplements.spar.spartan.dto.produto.ProdutoRequest;
import com.suplements.spar.spartan.dto.produto.ProdutoResponse;

import java.util.List;

public interface IProdutoService {

    ProdutoResponse create(ProdutoRequest produtoRequest);
    List<ProdutoResponse> list();
    ProdutoResponse listById(long id);
    ProdutoResponse update (long id, ProdutoRequest produtoRequest);
    void delete(long id);
}
