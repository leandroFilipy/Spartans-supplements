package com.suplements.spar.spartan.mapper.produto;

import com.suplements.spar.spartan.dto.produto.ProdutoRequest;
import com.suplements.spar.spartan.dto.produto.ProdutoResponse;
import com.suplements.spar.spartan.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper implements IProdutoMapper{

    @Override
    public Produto toEntity(ProdutoRequest produtoRequest){

        return new Produto(produtoRequest.nome(),
                produtoRequest.preco(),
                produtoRequest.descricao(),
                produtoRequest.peso(),
                produtoRequest.categoria(),
                produtoRequest.imagemUrl(),
                produtoRequest.quantidadeEstoque()
        );
    }

    @Override
    public ProdutoResponse toResponse(Produto produto){

        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getDescricao(),
                produto.getPeso(),
                produto.getCategoria(),
                produto.getImagemUrl(),
                produto.getQuantidadeEstoque()
        );
    }
}
