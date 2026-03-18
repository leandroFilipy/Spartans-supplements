package com.suplements.spar.spartan.service;

import com.suplements.spar.spartan.dto.ProdutoRequest;
import com.suplements.spar.spartan.dto.ProdutoResponse;
import com.suplements.spar.spartan.mapper.ProdutoMapper;
import com.suplements.spar.spartan.model.Produto;
import com.suplements.spar.spartan.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;


    public ProdutoResponse create(ProdutoRequest produtoRequest){

        Produto produto = produtoMapper.toEntity(produtoRequest);
        Produto produtoSalvo = produtoRepository.save(produto);
        ProdutoResponse produtoResponse = produtoMapper.toResponse(produtoSalvo);

        return produtoResponse;
    }

    public List<ProdutoResponse> list (){
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoResponse> dtos = new ArrayList<>();

        for (Produto p : produtos){
            dtos.add(produtoMapper.toResponse(p));
        }

        return dtos;
    }

    public ProdutoResponse listById(long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no product with this ID"));
        ProdutoResponse produtoResponse = produtoMapper.toResponse(produto);

        return produtoResponse;
    }

    public ProdutoResponse update(long id, ProdutoRequest produtoRequest){

        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no product with this ID"));
        produto.setNome(produto.getNome());
        produto.setPreco(produto.getPreco());
        produto.setDescricao(produto.getDescricao());
        produto.setPeso(produto.getPeso());
        produto.setCategoria(produto.getCategoria());
        produto.setImagemUrl(produto.getImagemUrl());
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        ProdutoResponse produtoResponse = produtoMapper.toResponse(produto);

        return produtoResponse;
    }

    public void delete(long id){
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
        }else {
            throw new RuntimeException("There is no product with this ID");
        }
    }

}
