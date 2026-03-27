package com.suplements.spar.spartan.service.produto;

import com.suplements.spar.spartan.dto.produto.ProdutoRequest;
import com.suplements.spar.spartan.dto.produto.ProdutoResponse;
import com.suplements.spar.spartan.mapper.produto.IProdutoMapper;
import com.suplements.spar.spartan.mapper.produto.ProdutoMapper;
import com.suplements.spar.spartan.model.Produto;
import com.suplements.spar.spartan.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService implements IProdutoService{

    private final ProdutoRepository produtoRepository;
    private final IProdutoMapper iProdutoMapper;


    @Override
    public ProdutoResponse create(ProdutoRequest produtoRequest){

        Produto produto = iProdutoMapper.toEntity(produtoRequest);
        Produto produtoSalvo = produtoRepository.save(produto);
        ProdutoResponse produtoResponse = iProdutoMapper.toResponse(produtoSalvo);

        return produtoResponse;
    }

    @Override
    public List<ProdutoResponse> list (){
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoResponse> dtos = new ArrayList<>();

        for (Produto p : produtos){
            dtos.add(iProdutoMapper.toResponse(p));
        }

        return dtos;
    }

    @Override
    public ProdutoResponse listById(long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no product with this ID"));
        ProdutoResponse produtoResponse = iProdutoMapper.toResponse(produto);

        return produtoResponse;
    }

    @Override
    public ProdutoResponse update(long id, ProdutoRequest produtoRequest){

        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no product with this ID"));
        produto.setNome(produtoRequest.nome());
        produto.setPreco(produtoRequest.preco());
        produto.setDescricao(produtoRequest.descricao());
        produto.setPeso(produtoRequest.peso());
        produto.setCategoria(produtoRequest.categoria());
        produto.setImagemUrl(produtoRequest.imagemUrl());
        produto.setQuantidadeEstoque(produtoRequest.quantidadeEstoque());

        Produto produtoSalvo = produtoRepository.save(produto);

        ProdutoResponse produtoResponse = iProdutoMapper.toResponse(produtoSalvo);

        return produtoResponse;
    }

    @Override
    public void delete(long id){
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
        }else {
            throw new RuntimeException("There is no product with this ID");
        }
    }

}
