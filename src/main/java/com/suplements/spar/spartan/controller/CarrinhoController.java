package com.suplements.spar.spartan.controller;


import com.suplements.spar.spartan.model.Carrinho;
import com.suplements.spar.spartan.model.Produto;
import com.suplements.spar.spartan.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
@RequiredArgsConstructor
public class CarrinhoController {

    private final CarrinhoService service;

    @PostMapping("/create/{usuarioId}")
    public Carrinho create(@PathVariable Long usuarioId){
        return service.createCart(usuarioId);
    }
    @PostMapping("/add/{idCarrinho}/{idProduct}/{quantidade}")
    public Carrinho addItem (@PathVariable long idCarrinho, @PathVariable long idProduct, @PathVariable int quantidade){
        return service.addProduct(idCarrinho, idProduct, quantidade);
    }
    @DeleteMapping("/remove/{idCarrinho}/{item}")
    public Carrinho remove (@PathVariable long idCarrinho,@PathVariable long item){
        return service.removeProduct(idCarrinho,item);
    }
}
