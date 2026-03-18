package com.suplements.spar.spartan.controller;

import com.suplements.spar.spartan.dto.produto.ProdutoRequest;
import com.suplements.spar.spartan.dto.produto.ProdutoResponse;
import com.suplements.spar.spartan.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping("/register")
    public ProdutoResponse create(@Valid @RequestBody ProdutoRequest produtoRequest){
        try{
            return produtoService.create(produtoRequest);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/list")
    public List<ProdutoResponse> list (){
        try{
            return produtoService.list();
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping("/list/{id}")
    public ProdutoResponse listById(@PathVariable long id){
        try{
            return produtoService.listById(id);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ProdutoResponse update (@Valid @PathVariable long id, @RequestBody ProdutoRequest produtoRequest){
        try{
           return produtoService.update(id, produtoRequest);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable long id){
        try{
            produtoService.delete(id);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
