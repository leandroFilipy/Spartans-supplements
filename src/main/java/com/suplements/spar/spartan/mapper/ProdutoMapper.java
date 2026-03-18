package com.suplements.spar.spartan.mapper;

import com.suplements.spar.spartan.dto.ProdutoRequest;
import com.suplements.spar.spartan.dto.ProdutoResponse;
import com.suplements.spar.spartan.model.Produto;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

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
